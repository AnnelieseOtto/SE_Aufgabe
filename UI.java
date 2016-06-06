package Strategy;

import java.awt.event.*;
import java.util.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;

public class UI extends JFrame{

	private JTextArea textUnten;
	private JTextArea textOben;
	private JButton encrypt;;
	private JButton decrypt;
	private JComboBox comboBox;
	private Map<String, EncryptionStrategy> encryptionMap;
	private EncryptionStrategy encryptor;
	
	public UI() {
		encryptionMap = new HashMap<String, EncryptionStrategy>();
		encryptionMap.put("Reverse", new ReverseEncryption());
		encryptionMap.put("Copy", new CopyEncryption());
		createUI();
		Object selectedStrategy = comboBox.getSelectedItem();
		encryptor = encryptionMap.get(selectedStrategy);
	}
	
	ActionListener buttonHandler = new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getActionCommand().equals("Encrypt")){
				//System.out.print("encrypt");
				String old = textOben.getText();
				String encrypted = encryptor.encrypt(old);
					//Debug System.out.print(encrypted);
				textUnten.setText(encrypted);
			}
			else if(e.getActionCommand().equals("Decrypt")){
				String old = textUnten.getText();
				String decrypted = encryptor.decrypt(old);
				textOben.setText(decrypted);
			}			
		}
	};
	
	ActionListener comboBoxHandler = new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent e) {
			Object selectedStrategy = comboBox.getSelectedItem();
			encryptor = encryptionMap.get(selectedStrategy);			
		}		
	};

	public void createUI(){
		Box box = Box.createVerticalBox();
		this.add(box);
		
		textOben = new JTextArea();
			textOben.setBorder(new TitledBorder("Original"));
		textUnten = new JTextArea();
			textUnten.setBorder(new TitledBorder("Encrypted"));
		
		JPanel buttonpanel = new JPanel();
			encrypt = new JButton("Encrypt");
				encrypt.addActionListener(buttonHandler);
			decrypt = new JButton("Decrypt");
				decrypt.addActionListener(buttonHandler);
			comboBox = new JComboBox(encryptionMap.keySet().toArray());
				comboBox.addActionListener(comboBoxHandler);
				
			buttonpanel.add(encrypt);
			buttonpanel.add(decrypt);
			buttonpanel.add(comboBox);
		
		
			box.add(textOben);
			box.add(textUnten);
			box.add(buttonpanel);
			
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(300,300);
		
	}
	
	public static void main(String[] args) {
		JFrame frame = new UI();
	}

}
