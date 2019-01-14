package in.iqing.tencentgame.net.bean.response;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by ZuoShu on 18/2/10.
 */
public class GameToken implements Serializable {
    @SerializedName("code")
    private int code;

    @SerializedName("token")
    private String token;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
