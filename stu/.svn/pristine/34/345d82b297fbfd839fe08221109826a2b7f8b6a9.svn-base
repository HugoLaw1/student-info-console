package seehope.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import seehope.dao.UserDao;
import seehope.model.UserModel;

public class SecurityProvider {

    public static final String CURRENT$USER = "CURRENT$USER";
    public static final String CURRENT$CONTEXT = "CURRENT$CONTEXT";
    /**
     * @param request
     */
    public void logout(HttpServletRequest request) {
        HttpSession session = getSession(request);
        if (session != null) {
            session.invalidate();
        }
    }

    /**
     * @param request
     * @return
     */
    public HttpSession getSession(HttpServletRequest request) {
        return request.getSession();
    }

    /**
     * @param request
     * @param user
     */
    public void setCurrentUser(UserModel user, HttpServletRequest request) {
        HttpSession session = getSession(request);
        session.setAttribute(CURRENT$USER, user);
        String context = UserDao.getRoleContext(user);
        session.setAttribute(CURRENT$CONTEXT, context);
    }
    
    public String getCurrentContext(HttpServletRequest request) {
    	HttpSession session = getSession(request);
        Object obj = session.getAttribute(CURRENT$CONTEXT);
        if (obj == null) {
            return null;
        } else {
            return (String) obj;
        }
    }

    /**
     * @param request
     * @return
     */
    public UserModel getCurrentUser(HttpServletRequest request) {
        HttpSession session = getSession(request);
        Object obj = session.getAttribute(CURRENT$USER);
        if (obj == null) {
            return null;
        } else {
            return (UserModel) obj;
        }
    }

}
