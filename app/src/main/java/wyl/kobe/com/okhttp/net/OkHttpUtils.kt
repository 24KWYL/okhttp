package wyl.kobe.com.okhttp.net

import okhttp3.*
import java.io.IOException
import java.util.concurrent.TimeUnit

/**
 * okhttp单例
 */
class OkHttpUtils private constructor() {

    companion object {
        val instance: OkHttpUtils by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            OkHttpUtils()
        }
    }

    private val client: OkHttpClient by lazy {
        OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .build()
    }

    fun get(url: String, callBack: ResponseCallBack) {
        var request = Request.Builder()
            .url(Api.baseUrl + url)
            .build()
        client.newCall(request).enqueue(
            object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                    callBack?.onFail(e.toString())
                }

                override fun onResponse(call: Call, response: Response) {
                    callBack?.onSuccess(response.body()!!.string())
                }

            }
        )
    }

    fun post(url: String, requestParams: RequestParams, callBack: ResponseCallBack) {
        var requestBody = FormBody.Builder()
        requestParams.forEach {
            requestBody.add(it.key, it.value.toString())
        }
        var request = Request.Builder()
            .url(Api.baseUrl + url)
            .post(requestBody.build())
            .build()
        client.newCall(request).enqueue(
            object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                    callBack?.onFail(e.toString())
                }

                override fun onResponse(call: Call, response: Response) {
                    callBack?.onSuccess(response.body()!!.string())
                }

            }
        )
    }


}