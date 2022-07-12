package Hosptial;


import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.table.*;

//DataBase Packages

import java.sql.*;

//Main Class		

class PMSSwing extends JFrame implements ActionListener
{
	private Statement st;
	private Connection con;

	//List of Labels

	private JLabel lblOldMedicineID;
	private JLabel lblMedicineID;
	private JLabel lblMediTitle;
	private JLabel lblQty;
	private JLabel lblPrice;

	//List of TextFields

	private JTextField txtOldMedicineID;
	private JTextField txtMedicineID;
	private JTextField txtMediTitle;
	private JTextField txtQty;
	private JTextField txtPrice;

	//List of Buttons

	private JButton btnSaveAdd;
	private JButton btnSaveEdit;
	private JButton btnSaveDelete;
	private JButton btnAdd;
	private JButton btnEdit;
	private JButton btnDelete;
	private JButton btnExit;
	private JButton btnRefresh;
	private JButton btnCancel;

	//List of Panel

	private JPanel btnpanel;
	private JPanel panel;
	private JTable table;

	//Table

	private DefaultTableModel tmodel;

	//Container

	private Container cpane;

	PMSSwing()
	{	}

	PMSSwing(int choice)
	{
		switch(choice)
		{
			case 1:
				//Initial Window

				setTitle("PHARMACY MANAGEMENT SYSTEM");
				setBounds(275, 250, 450, 230);
				setResizable(false);

				//cotainer

				cpane = getContentPane();

				//components

				tmodel = new DefaultTableModel();
				table = new JTable(tmodel);
				SetColHeader();

				btnpanel = new JPanel(new GridLayout(1, 5, 5, 0));
				btnAdd = new JButton ("Add");
				btnEdit = new JButton ("Edit");
				btnDelete = new JButton ("Delete");
				btnRefresh = new JButton ("Refresh");
				btnExit = new JButton ("Exit");

				btnAdd.addActionListener(this);
				btnEdit.addActionListener(this);
				btnDelete.addActionListener(this);
				btnRefresh.addActionListener(this);
				btnExit.addActionListener(this);

				btnpanel.add(btnAdd);
				btnpanel.add(btnEdit);
				btnpanel.add(btnDelete);
				btnpanel.add(btnRefresh);
				btnpanel.add(btnExit);

				cpane.add(new JScrollPane(table));
				cpane.add(btnpanel, BorderLayout.SOUTH);
				break;
			case 2:
				//Appending Window

				setTitle("Addition of data...");
				setBounds(275, 275, 400, 200);
				setResizable(false);

				//cotainer

				cpane = getContentPane();
				cpane.setLayout(new FlowLayout());

				//Components

				panel = new JPanel(new GridLayout(8, 1, 5, 0));

				lblMedicineID = new JLabel(" MediID ");
				lblMediTitle = new JLabel(" MediTitle ");
				lblQty = new JLabel(" Qty ");
				lblPrice = new JLabel(" Price ");

				txtMedicineID = new JTextField(15);
				txtMediTitle = new JTextField(15);
				txtQty = new JTextField(15);
				txtPrice = new JTextField(15);

				panel.add(lblMedicineID);
				panel.add(txtMedicineID);
				panel.add(lblMediTitle);
				panel.add(txtMediTitle);
				panel.add(lblQty);
				panel.add(txtQty);
				panel.add(lblPrice);
				panel.add(txtPrice);

				btnpanel = new JPanel(new GridLayout(2, 1, 10, 5));
				btnSaveAdd = new JButton ("Save");
				btnCancel = new JButton ("Cancel");

				btnSaveAdd.addActionListener(this);
				btnCancel.addActionListener(this);

				btnpanel.add(btnSaveAdd);
				btnpanel.add(btnCancel);

				cpane.add(panel);
				cpane.add(btnpanel, BorderLayout.EAST);
				break;
			case 3:
				//Editing window

				setTitle("Updation of data...");
				setBounds(350, 350, 400, 250);
				setResizable(false);

				//cotainer

				cpane = getContentPane();
				cpane.setLayout(new FlowLayout());

				//Components

				panel = new JPanel(new GridLayout(10, 1, 5, 0));
				lblOldMedicineID = new JLabel(" OldMedicineID ");
				txtOldMedicineID = new JTextField(15);

				lblMedicineID = new JLabel(" NewMediID ");
				lblMediTitle = new JLabel(" MediTitle ");
				lblQty = new JLabel(" Qty ");
				lblPrice = new JLabel(" Price ");

				txtMedicineID = new JTextField(15);
				txtMediTitle = new JTextField(15);
				txtQty = new JTextField(15);
				txtPrice = new JTextField(15);


				panel.add(lblOldMedicineID);
				panel.add(txtOldMedicineID);
				panel.add(lblMedicineID);
				panel.add(txtMedicineID);
				panel.add(lblMediTitle);
				panel.add(txtMediTitle);
				panel.add(lblQty);
				panel.add(txtQty);
				panel.add(lblPrice);
				panel.add(txtPrice);

				btnpanel = new JPanel(new GridLayout(2, 1, 10, 5));
				btnSaveEdit = new JButton ("Save");
				btnCancel = new JButton ("Cancel");

				btnSaveEdit.addActionListener(this);
				btnCancel.addActionListener(this);

				btnpanel.add(btnSaveEdit);
				btnpanel.add(btnCancel);

				cpane.add(panel);
				cpane.add(btnpanel, BorderLayout.EAST);
				break;
			case 4:
				//Deleting window

				setTitle("Removal of data...");
				setBounds(300, 300, 300, 125);
				setResizable(false);

				//cotainer

				cpane = getContentPane();
				cpane.setLayout(new FlowLayout());

				//Components

				panel = new JPanel(new GridLayout(2, 1, 5, 0));
				lblMedicineID = new JLabel("MedicineID to be deleted: ");
				txtMedicineID = new JTextField(15);

				panel.add(lblMedicineID);
				panel.add(txtMedicineID);

				btnpanel = new JPanel(new GridLayout(2, 1, 10, 5));
				btnSaveDelete = new JButton ("Delete");
				btnCancel = new JButton ("Cancel");

				btnSaveDelete.addActionListener(this);
				btnCancel.addActionListener(this);

				btnpanel.add(btnSaveDelete);
				btnpanel.add(btnCancel);

				cpane.add(panel);
				cpane.add(btnpanel, BorderLayout.EAST);
				break;
		}
		//Window Properties

		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setVisible(true);

		//conection to DataBase

		ConnectToDatabase();
	}

	public void actionPerformed (ActionEvent ae)
	{
		if (ae.getSource() == btnAdd)
		{
			new PMSSwing(2);
		}
		else if (ae.getSource() == btnEdit)
		{
			new PMSSwing(3);
		}
		else if (ae.getSource() == btnDelete)
		{
			new PMSSwing(4);
		}
		else if (ae.getSource() == btnExit)
		{
			System.exit(0);
		}
		else if (ae.getSource() == btnCancel)
		{
			setVisible(false);
		}
		else if(ae.getSource() == btnSaveAdd)
		{
			AddData(txtMedicineID.getText(), txtMediTitle.getText(), txtQty.getText(), txtPrice.getText());
			txtMedicineID.setText("");
			txtMediTitle.setText("");
			txtQty.setText("");
			txtPrice.setText("");
		}
		else if(ae.getSource() == btnSaveEdit)
		{
			EditData(txtMedicineID.getText(), txtMediTitle.getText(), txtQty.getText(),txtPrice.getText(), txtOldMedicineID.getText());
			txtOldMedicineID.setText("");
			txtMedicineID.setText("");
			txtMediTitle.setText("");
			txtQty.setText("");
			txtPrice.setText("");
		}
		else if(ae.getSource() == btnSaveDelete)
		{
			DeleteData(txtMedicineID.getText());
			txtMedicineID.setText("");
		}
		else if(ae.getSource() == btnRefresh)
		{
			RetrieveData();
		}
	}

	public static void main(String arg[])
	{
		PMSSwing c = new PMSSwing(1);
		c.RetrieveData();
	}

	private void SetColHeader()
	{
		tmodel.addColumn("MedicineID");
		tmodel.addColumn("MediTitle");
		tmodel.addColumn("Qty");
		tmodel.addColumn("Price");

	}

	private void ConnectToDatabase ()
	{
		try
		{
			String dsn = "Medi";

			//load driver
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

			//make connection
			con = DriverManager.getConnection("jdbc:odbc:" + dsn);

			//create statement
			st = con.createStatement();
		}
		catch (Exception e) {System.out.println(e);}
	}

	private void AddData (String code, String title, String hour, String price)
	{
		try
		{
			//prepare statement
			String qry = "Insert into MediInfo values (?, ?, ?, ?)";
			System.out.println(code + "\t"+title+ "\t"+hour+ "\t"+price);
			//System.out.println("Read only "+con.isReadOnly());
			//System.out.println("Closed "+con.isClosed());

			PreparedStatement ps = con.prepareStatement(qry);

			ps.setString(1, code);
			ps.setString(2, title);
			ps.setString(3, hour);
			ps.setString(4,price);

			ps.executeUpdate();
		}
		catch(Exception e) {System.out.println(e + "\t" + e.getMessage());	}
	}

	private void EditData (String code, String title, String hour, String price, String cond)
	{
		try
		{
			//prepare statement
			String qry = "Update MediInfo set MedicineID = ?, MediTitle = ?, Qty = ?, Price = ? where MedicineID = ?";
			PreparedStatement ps = con.prepareStatement(qry);

			ps.setString(1, code);
			ps.setString(2, title);
			ps.setString(3, hour);
			ps.setString(4, price);

			ps.setString(5, cond);

			ps.executeUpdate();
		}
		catch(Exception e) {System.out.println(e);	}
	}

	private void DeleteData (String cond)
	{
		try
		{
			//prepare statement
			String qry = "Delete from MediInfo where MedicineID = ?";
			PreparedStatement ps = con.prepareStatement(qry);

			ps.setString(1, cond);

			ps.executeUpdate();
		}
		catch(Exception e) {System.out.println(e);	}
	}

	private void RetrieveData ()
	{
		try
		{
			int row = tmodel.getRowCount();
			while(row > 0)
			{
				row--;
				tmodel.removeRow(row);
			}

			//execute query
			ResultSet rs = st.executeQuery("Select * from MediInfo");

			//get metadata
			ResultSetMetaData md = rs.getMetaData();
			int colcount = md.getColumnCount();

			Object[] data = new Object[colcount];
			//extracting data

			while (rs.next())
			{
				for (int i=1; i<=colcount; i++)
				{
					data[i-1] = rs.getString(i);
				}
				tmodel.addRow(data);
			}
		}
		catch(Exception e) {System.out.println(e);	}
	}
}