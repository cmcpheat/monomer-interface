package com.monomer.app;

import com.monomer.gui.pages.GUI;
import com.monomer.gui.pages.Theme;

public class Main {

	public static void main(String[] args) {
		Theme theme = new Theme();
		theme.setTheme();
		GUI gui = new GUI();
	}

}
