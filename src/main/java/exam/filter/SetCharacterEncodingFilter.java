package exam.filter;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author tiandao
 * @date 2018/8/13 10:04
 */
public class SetCharacterEncodingFilter implements Filter{
    //存储编码格式信息
    private String encode = null;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //获取在web.xml文件中配置了的编码格式的信息
        this.encode = filterConfig.getInitParameter("encode");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        //转换
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        if(this.encode != null && !this.encode.equals("")){
            request.setCharacterEncoding(this.encode);
            response.setCharacterEncoding(this.encode);
        }else{
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
        }
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
