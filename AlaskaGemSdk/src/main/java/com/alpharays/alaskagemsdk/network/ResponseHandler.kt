package com.alpharays.alaskagemsdk.network

import android.util.Log
import com.alpharays.alaskagemsdk.AlaskaGemSdkConstants.INTERNAL_SERVER_ERROR
import com.alpharays.alaskagemsdk.AlaskaGemSdkConstants.SOMETHING_WENT_WRONG
import retrofit2.Response

class ResponseHandler {
    suspend fun <T : Any> callAPI(call: suspend () -> Response<T>): ResponseResult<T> {
        return try {
            val apiResponse = call()
            if (apiResponse.isSuccessful && apiResponse.body() != null) {
                ResponseResult.Success(apiResponse.body()!!)
            } else {
                val errorObj = apiResponse.errorBody()!!.charStream().readText()
                ResponseResult.Error(INTERNAL_SERVER_ERROR)
            }
        } catch (e: Exception) {
            Log.e("checkingException", e.message.toString())
            ResponseResult.Error(SOMETHING_WENT_WRONG)
        }
    }
}
