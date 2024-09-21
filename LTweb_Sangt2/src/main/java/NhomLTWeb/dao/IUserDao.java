package NhomLTWeb.dao;

import NhomLTWeb.model.UserModel;

import java.util.List;

public interface IUserDao {
    UserModel findByUserName(String userName);
    List<UserModel> findAll();
    UserModel findById(int id);
    void insert(UserModel user);
    boolean checkExistEmail(String email);
    boolean checkExistUsername(String username);
    UserModel findByUsernameAndEmail(String username, String email);
    boolean updatePassword(String username, String password);
}