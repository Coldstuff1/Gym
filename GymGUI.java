import javax.swing.*;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.*;

public class GymGUI extends JFrame implements ActionListener {

  JButton newMember;
  JButton findId;
  JButton findName;
  JTextField textField;
  MemberTree FaubertGym;

    GymGUI() {
      FaubertGym = new MemberTree();
      this.setTitle("Gym Database");
		  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setResizable(true);
			this.setSize(1280, 720);
      this.setLayout(new FlowLayout());
      newMember = new JButton("Add Member");
      newMember.setPreferredSize(new Dimension(150,40));
      newMember.addActionListener(this);
      this.add(newMember);
      textField = new JTextField();
      textField.setPreferredSize(new Dimension(250,40));
      this.add(textField);
      findId = new JButton("Find Id");
      findId.setPreferredSize(new Dimension(150, 40));
      findId.addActionListener(this);
      this.add(findId);
      findName = new JButton("Find Name");
      findName.setPreferredSize(new Dimension(150, 40));
      findName.addActionListener(this);
      this.add(findName);
      this.setVisible(true);


    }

      @Override
      public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if(command.equals("Find Name")) {
          Member output = FaubertGym.findName(textField.getText());
          System.out.println(output.toString());
          System.out.println(output.getAddresses());
          System.out.println(output.getPaymentMethods());
        }
        if(command.equals("Find Id")) {
          Member output = FaubertGym.findId(Integer.parseInt(textField.getText()));
          System.out.println(output.toString());
          System.out.println(output.getAddresses());
          System.out.println(output.getPaymentMethods());
        }
        if(command.equals("Add Member")) {
          AddMemberPage addMemberPage = new AddMemberPage();

        }

      }

      private class AddMemberPage implements ActionListener{
        JFrame addMemberPage = new JFrame();
        JTextField nameField = new JTextField();
        JTextField ageField = new JTextField();
        JTextField genderField = new JTextField();
        JCheckBox superMemberCheckBox = new JCheckBox();
        JTextField streetField = new JTextField();
        JTextField cityField = new JTextField();
        JTextField provinceField = new JTextField();
        JTextField countryField = new JTextField();
        JTextField postalField = new JTextField();
        JTextField cardField = new JTextField();
        JTextField cardNumField = new JTextField();
        JTextField secCodeField = new JTextField();
        JTextField expDateField = new JTextField();
        JButton addMemberButton = new JButton("Add");
        AddMemberPage() {
          addMemberPage.setTitle("Add Member");
          addMemberPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          addMemberPage.setResizable(true);
          addMemberPage.setSize(1280, 720);
          addMemberPage.setLayout(new FlowLayout());
          nameField.setPreferredSize(new Dimension(250, 40));
          addMemberPage.add(nameField);
          ageField.setPreferredSize(new Dimension(250, 40));
          addMemberPage.add(ageField);
          genderField.setPreferredSize(new Dimension(250, 40));
          addMemberPage.add(genderField);
          streetField.setPreferredSize(new Dimension(250, 40));
          addMemberPage.add(streetField);
          cityField.setPreferredSize(new Dimension(250, 40));
          addMemberPage.add(cityField);
          provinceField.setPreferredSize(new Dimension(250, 40));
          addMemberPage.add(provinceField);
          countryField.setPreferredSize(new Dimension(250, 40));
          addMemberPage.add(countryField);
          postalField.setPreferredSize(new Dimension(250, 40));
          addMemberPage.add(postalField);
          cardField.setPreferredSize(new Dimension(250, 40));
          addMemberPage.add(cardField);
          cardNumField.setPreferredSize(new Dimension(250, 40));
          addMemberPage.add(cardNumField);
          secCodeField.setPreferredSize(new Dimension(250, 40));
          addMemberPage.add(secCodeField);
          expDateField.setPreferredSize(new Dimension(250, 40));
          addMemberPage.add(expDateField);
          addMemberButton.setPreferredSize(new Dimension(150, 40));
          addMemberButton.addActionListener(this);
          addMemberPage.add(addMemberButton);
          addMemberPage.setVisible(true);




        }

        @Override
        public void actionPerformed(ActionEvent e) {
          String command = e.getActionCommand();
          if(command.equals("Add")) {
            Member member = new Member(nameField.getText(), Integer.parseInt(ageField.getText()), genderField.getText(), false);
            Address address = new Address(streetField.getText(), cityField.getText(), provinceField.getText(), countryField.getText(), postalField.getText());
            PaymentMethod paymentMethod = new PaymentMethod(cardField.getText(), cardNumField.getText(), expDateField.getText(), secCodeField.getText());
            member.addAddress(address);
            member.addPaymentMethod(paymentMethod);
            FaubertGym.insert(member);
            addMemberPage.dispose();

          }

        }

      }




}
