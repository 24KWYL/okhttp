package wyl.kobe.com.okhttp.bean

class LoginData {

    /**
     * data : {"chapterTops":[],"collectIds":[],"email":"","icon":"","id":15158,"password":"","token":"","type":0,"username":"gailun"}
     * errorCode : 0
     * errorMsg :
     */

    var data: DataBean? = null
    var errorCode: Int = 0
    var errorMsg: String? = null

    class DataBean {
        /**
         * chapterTops : []
         * collectIds : []
         * email :
         * icon :
         * id : 15158
         * password :
         * token :
         * type : 0
         * username : gailun
         */

        var email: String? = null
        var icon: String? = null
        var id: Int = 0
        var password: String? = null
        var token: String? = null
        var type: Int = 0
        var username: String? = null
        var chapterTops: List<*>? = null
        var collectIds: List<*>? = null
    }

    override fun toString(): String {
        return data!!.username + ";" + data!!.password
    }
}