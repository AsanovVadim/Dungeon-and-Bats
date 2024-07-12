package org.dungeongame;

import javax.swing.*;

import org.dungeongame.carcass.Engine;
import org.dungeongame.carcass.transportation.Loader;


public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                Loader.load();
                Engine.init();
                Engine.start();
            }
        });
    }
}