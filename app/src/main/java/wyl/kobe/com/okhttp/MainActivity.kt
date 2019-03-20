package wyl.kobe.com.okhttp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import wyl.kobe.com.okhttp.net.Api
import wyl.kobe.com.okhttp.net.OkHttpUtils
import wyl.kobe.com.okhttp.net.RequestParams
import wyl.kobe.com.okhttp.net.ResponseCallBack

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv_get.setOnClickListener {
            OkHttpUtils.instance.get(Api.chaptersUrl, object : ResponseCallBack {
                override fun onSuccess(result: String) {
                    Log.e("wyl", result)
                }

                override fun onFail(result: String) {
                    Log.e("wyl", result)
                }

            })
        }

        btn_post.setOnClickListener {
            var requestParams = RequestParams()
            requestParams["username"] = user_name.text.toString()
            requestParams["password"] = password.text.toString()
            requestParams["repassword"] = password.text.toString()
            OkHttpUtils.instance.post(Api.registerUrl, requestParams, object : ResponseCallBack {
                override fun onSuccess(result: String) {
                    Log.e("wyl", result)
                }

                override fun onFail(result: String) {
                    Log.e("wyl", result)
                }

            })
        }
    }
}
