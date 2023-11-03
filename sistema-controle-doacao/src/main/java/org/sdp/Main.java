package org.sdp;


import org.sdp.database.dao.usuario.UsuarioDao;
import org.sdp.model.Usuario;
import org.sdp.view.login.TelaLogin;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        TelaLogin telaLogin = new TelaLogin();

        telaLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        telaLogin.setVisible(true);
    }
}