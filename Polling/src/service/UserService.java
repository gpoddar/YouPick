
package service;

import DAO.UserDAO;
import dto.User;

public class UserService {

    public long createUser(User user) {
        return new UserDAO().createUserProfile(user);
    }

    public int updateUser(User user) {
        return new UserDAO().updateUserProfile(user);
    }

    public Double findUserEmail(User user) {
        return new UserDAO().findUserByEmailID(user);
    }

    public Double findUserFb(User user) {
        return new UserDAO().findUserByFbUserID(user);
    }
}
