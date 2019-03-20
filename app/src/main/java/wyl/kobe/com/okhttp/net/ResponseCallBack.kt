package wyl.kobe.com.okhttp.net

interface ResponseCallBack {

    fun onSuccess(result: String)//成功

    fun onFail(result: String)//失败
}