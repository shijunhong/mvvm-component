package com.ikang.staffapp.ui.login

import androidx.lifecycle.MutableLiveData
import com.ikang.libmvi.base.BaseViewModel
import com.ikang.libmvi.network.RetrofitFactory
import com.ikang.staffapp.data.entity.OauthResp
import com.ikang.staffapp.http.ApiService
import com.ikang.staffapp.http.BASE_URL
import com.ikang.staffapp.http.interceptor.IKGlobalIntercept

/**
 * @author ikang-zhulk
 * @version 1.0.0
 * @describe {@link #}
 */
class LoginViewModule : BaseViewModel() {

    val service by lazy {
        RetrofitFactory.getService(
                ApiService::class.java,
                BASE_URL,
                IKGlobalIntercept()
        )
    }

    private var _mComicDetailResponse = MutableLiveData<OauthResp>()
    var mComicDetailResponse = _mComicDetailResponse


    /**
     * 测试登陆获取token
     */
    fun getLoginToken() {

        val params = mutableMapOf<String, String>()
        params.put("grant_type", "password")
        params.put("username", "xingikang")
        params.put("password", "123456")
        params.put("passwd_type", "password")
        params.put("channel_id", "app")
        params.put("channel_name", "android")
        params.put("captcha", "123456")
        params.put("captcha_id", "000000")

        launchOnlyresult({ service.getLoginToken(params) }, {
            _mComicDetailResponse.value = it
        })
    }


    fun getLoginSession() {


        val params = mutableMapOf<String, String>()
        params.put("token", "password")
        params.put("deviceType", "android")
        params.put("comefrom", "123456")
        params.put("passwd_type", "password")
        params.put("channel_id", "app")
        params.put("channel_name", "android")
        params.put("captcha", "123456")
        params.put("captcha_id", "000000")

        launchOnlyresult({ service.getLoginSession(params) }, {
            _mComicDetailResponse.value = it
        })
    }




    fun doubleCheckHttps() {
        launch({
            val loginSession = service.doubleCheckHttps("https://blog.tttsss.com/beta")
        })
    }

}