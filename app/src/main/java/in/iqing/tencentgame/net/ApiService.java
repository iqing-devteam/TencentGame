package in.iqing.tencentgame.net;


import in.iqing.tencentgame.net.bean.response.GameToken;
import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface ApiService {




    @GET("/tencent_login/")
    Flowable<GameToken> getTencentToken(@Query("uname")String uname,
                                        @Query("token")String token,
                                        @Query("sign")String sign,
                                        @Query("test")int test);


}

