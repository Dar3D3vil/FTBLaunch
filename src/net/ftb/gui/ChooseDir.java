package net.ftb.gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

import net.ftb.gui.panes.OptionsPane;

public class ChooseDir extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;

	private OptionsPane optionsPane;
	private String choosertitle = "Please select an install folder";

	public ChooseDir(OptionsPane optionsPane) {
		super();
		this.optionsPane = optionsPane;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JFileChooser chooser = new JFileChooser();
		chooser.setCurrentDirectory(new java.io.File(optionsPane.getInstallFolderText()));
		chooser.setDialogTitle(choosertitle);
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		chooser.setAcceptAllFileFilterUsed(false);

		if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
			System.out.println("getCurrentDirectory(): " + chooser.getCurrentDirectory());
			System.out.println("getSelectedFile() : " + chooser.getSelectedFile());
			optionsPane.setInstallFolderText(chooser.getSelectedFile().getPath());
		} else {
			System.out.println("No Selection ");
		}
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(200, 200);
	}
}