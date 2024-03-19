package com.example.test.network

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class NetworkOperations {
    suspend fun performLogin(username: String, password: String){
        return withContext(Dispatchers.IO) {
            val serverUrl =
                URL("https://your_server_url/api/login/$username/$password") // Replace with your server URL
            val urlConnection = serverUrl.openConnection() as HttpURLConnection
            try {
                val inputStream = urlConnection.inputStream
                val reader = BufferedReader(InputStreamReader(inputStream))
                val result = StringBuilder()
                var line: String?
                while (reader.readLine().also { line = it } != null) {
                    result.append(line)
                }
                result.toString()
            } catch (e: Exception) {
                Log.e("network", "error", e)
            } finally {
                urlConnection.disconnect()
            }
        }
    }

    suspend fun performRegistration(username: String, password: String) {
        return withContext(Dispatchers.IO) {
            val serverUrl =
                URL("https://your_server_url/api/register/$username/$password") // Replace with your server URL
            val urlConnection = serverUrl.openConnection() as HttpURLConnection
            try {
                val inputStream = urlConnection.inputStream
                val reader = BufferedReader(InputStreamReader(inputStream))
                val result = StringBuilder()
                var line: String?
                while (reader.readLine().also { line = it } != null) {
                    result.append(line)
                }
                result.toString()
            } catch (e: Exception) {
                Log.e("network", "error", e)
            } finally {
                urlConnection.disconnect()
            }
        }
    }
}

