package util;

public abstract class AbstractInfo {
	public abstract void usernameInput(String name);
	public abstract void passwordInput(String password);
	public abstract void loginClick();
	public abstract void authenticate(String username, String password);
}
