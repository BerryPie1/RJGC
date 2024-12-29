package util;

import com.alibaba.fastjson.JSONObject;
import com.jntoo.db.utils.DownloadRemoteImage;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspWriter;

/**
 * Info 工具类，比较杂什么都有
 */
public class Info extends com.jntoo.db.utils.InfoUtil {

    /**
     * 下载内容
     * @param content 待下载的内容
     * @return 返回下载后的内容
     */
    public static String download(String content) {
        HttpServletRequest request = Request.getRequest(); // 获取当前运行的目录
        String savePath = request.getSession().getServletContext().getRealPath("/"); // 保存位置
        return DownloadRemoteImage.run(content, savePath, "./upload"); // 将下载的内容保存在网站中
    }

    public static boolean isAjax() {
        HttpServletRequest request = Request.getRequest(); // 获取当前运行的目录
        String accept = request.getHeader("accept");
        if (accept != null && accept.indexOf("application/json") != -1) {
            return true;
        }

        String xRequestedWith = request.getHeader("X-Requested-With");
        if (xRequestedWith != null && xRequestedWith.indexOf("XMLHttpRequest") != -1) {
            return true;
        }

        String ajax = request.getParameter("format");
        if ("json".equalsIgnoreCase(ajax)) {
            return true;
        }
        return false;
    }

    public static String json_response(int code, String msg, Object data) {
        Request.getResponse().setContentType("application/json");
        JSONObject object = new JSONObject();
        object.put("code", code);
        object.put("msg", msg);
        object.put("data", data);
        return object.toJSONString();
    }

    public static String json_success(Object data) {
        return json_response(0, "操作成功", data);
    }

    public static String json_error(String msg, int code) {
        return json_response(code, msg, null);
    }

    public static String json_error(String msg) {
        return json_response(1, msg, null);
    }

    public static void showMessage(JspWriter out, String msg, String url) {
        String href = "location.href='" + url + "'";
        if (url.indexOf("javascript:") != -1) {
            href = url.substring(url.indexOf("javascript:"));
        }
        try {
            out.print("<script>alert('" + msg + "');" + href + "</script>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void showError(JspWriter out, String msg) {
        showError(out, msg, null);
    }

    public static void showError(JspWriter out, String msg, String url) {
        if (isAjax()) {
            try {
                out.print(json_error(msg));
            } catch (IOException e) {
                e.printStackTrace();
            }
            return;
        }
        showMessage(out, msg, url == null ? "javascript:history.go(-1)" : url);
    }

    public static void showSuccess(JspWriter out, String msg) {
        showSuccess(out, msg, null);
    }

    public static void showSuccess(JspWriter out, String msg, String url) {
        if (isAjax()) {
            try {
                out.print(json_success(msg));
            } catch (IOException e) {
                e.printStackTrace();
            }
            return;
        }
        showMessage(out, msg, url == null ? "javascript:location.href=document.referrer" : url);
    }
}
