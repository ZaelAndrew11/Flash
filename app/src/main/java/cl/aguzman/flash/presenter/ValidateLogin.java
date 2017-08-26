package cl.aguzman.flash.presenter;
import cl.aguzman.flash.data.CurrentUser;

public class ValidateLogin{

    private ValidateCallback callback;

    public ValidateLogin(ValidateCallback callback) {
        this.callback = callback;
    }

    public void loginValidate(){
        if (new CurrentUser().getCurrentUser() != null){
            callback.logged();
        }else{
            callback.signUp();
        }
    }
}
