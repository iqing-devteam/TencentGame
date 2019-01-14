package in.iqing.tencentgame.net;


/**
 * Created by Asura on 2016/8/15.
 */
public interface GlobalConfig {


    String SERVER_BASE_URL = "http://tencent-quin.iqing.com";
    String SERVER_TEST_BASE_URL = "http://tencent-quin.iqing.com";


    int CONNECT_TIMEOUT = 10;//连接超时10s
    int READ_TIMEOUT = 30;//读数据超时10s
    int WRITE_TIMEOUT = 30;//写数据超时10s
    String GSON_DATEFORMAT = "yyyy-MM-dd'T'HH:mm:ss'Z'"; //日期gson转换格式;

}
