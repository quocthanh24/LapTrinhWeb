package NhomLTWeb;

import java.util.List;


import NhomLTWeb.dao.Implement.UserDaoImpl;
import NhomLTWeb.services.IUserService;
import NhomLTWeb.model.UserModel;

import NhomLTWeb.services.Implement.*;
public class ProgramTest {

	public static void main(String[] args) throws ClassNotFoundException {
		UserModel user = new UserModel("3","4@10","2","2");
		IUserService ser = new UserService();
		ser.insert(user);
	}

}
