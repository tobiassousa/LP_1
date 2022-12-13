package Animais;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Animais.Animais;
import Animais.Conexao;

import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.awt.event.ActionEvent;


public class FormAnimais extends JFrame {

	private JPanel contentPane;
	private JTextField tfSexo;
	private JTextField tfPeso;
	private JTextField tfIdade;
	private JTextField tfNome;
	HashSet<String> Animais;
	ArrayList <Animais> x;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormAnimais frame = new FormAnimais();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FormAnimais() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 472, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		x = new ArrayList<>();
		Animais = new HashSet<String>();
		
		JPanel jPanel1 = new JPanel();
		jPanel1.setBackground(Color.WHITE);
		contentPane.add(jPanel1, BorderLayout.NORTH);
		
		JLabel Sexo = new JLabel();
		Sexo.setText("Sexo");
		Sexo.setFont(new Font("Arial", Font.BOLD, 14));
		
		tfSexo = new JTextField();
		tfSexo.setFont(new Font("Arial", Font.PLAIN, 14));
		
		JLabel Cor1 = new JLabel();
		Cor1.setText("Aro");
		Cor1.setFont(new Font("Arial", Font.BOLD, 14));
				
		JLabel Peso = new JLabel();
		Peso.setText("Peso");
		Peso.setFont(new Font("Arial", Font.BOLD, 14));
		
		tfPeso = new JTextField();
		tfPeso.setFont(new Font("Arial", Font.PLAIN, 14));
		
		JLabel Idade = new JLabel();
		Idade.setText("Idade");
		Idade.setFont(new Font("Arial", Font.BOLD, 14));
		
		tfIdade = new JTextField();
		tfIdade.setFont(new Font("Arial", Font.PLAIN, 14));
		
		JLabel Nome = new JLabel();
		Nome.setText("Nome");
		Nome.setFont(new Font("Arial", Font.BOLD, 14));
		
		tfNome = new JTextField();
		tfNome.setFont(new Font("Arial", Font.PLAIN, 14));
		
		JButton Cadastrar1 = new JButton();
		Cadastrar1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Animais c1 = new Animais();
				c1.setNome(tfNome.getText());
				c1.setPeso(tfPeso.getText());
				c1.setIdade(tfIdade.getText());			
				c1.setSexo(tfSexo.getText());
							
				
				try {
					Connection con = Conexao.faz_conexao();
					String sql = "insert into animais(nome, peso, idade, sexo) values (?, ?, ?, ?)";
					
					PreparedStatement stmt = con.prepareStatement(sql);
					stmt.setString(1, c1.getNome());
					stmt.setString(2, c1.getPeso());
					stmt.setString(3, c1.getIdade());
					stmt.setString(4, c1.getSexo());
					
					
				stmt.execute();
				stmt.close();
				con.close();
				JOptionPane.showMessageDialog(null, "Cadastrado com sucesso! Visualizando Vagas");

			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "Faltando informações obrigatórias!!");
					
				}
				
			}
		});
		Cadastrar1.setText("Cadastrar");
		Cadastrar1.setFont(new Font("Arial", Font.BOLD, 14));
		Cadastrar1.setBackground(new Color(204, 204, 255));
		
		JButton Cadastrar = new JButton();
		Cadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 System.exit(0);
			}
		});
		Cadastrar.setText("Sair");
		Cadastrar.setFont(new Font("Arial", Font.BOLD, 14));
		Cadastrar.setBackground(new Color(204, 204, 255));
		
		JLabel jLabel2 = new JLabel();
		jLabel2.setText("Animais");
		jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel2.setFont(new Font("Arial", Font.BOLD, 24));
		
		JButton Dicionario = new JButton();
		Dicionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try (BufferedReader br = new BufferedReader(new FileReader("C:\\\\Users\\\\TI ADCe\\\\eclipse-workspace\\\\Animais\\\\src\\\\animals.csv"))){
					String line = br.readLine();
					Map<String, String> map = new HashMap<>();
					while (line != null) {
						String [] fields = line.split(";");
						
						String nomec = "Nome: ";
						String nome = fields[0];
						String pesoc = "Peso: ";
						String peso = fields[1];
						String idadec = "Idade: ";
						String idade = fields[2];
						String sexoc = "Sexo: ";
						String sexo = fields[3];
						
						
						map.put(nomec, nome);
						map.put(pesoc, peso);
						map.put(idadec, idade);
						map.put(sexoc, sexo);
						
						
						line = br.readLine();
						
					}
					System.out.println("Dicionario");
					for (String key: map.keySet()) {
						
						System.out.println(key + map.get(key));
						JOptionPane.showMessageDialog(null, key + map.get(key));
						
					}
				} catch (Exception e2) {
					System.out.println("Error: " + e2.getMessage());
					// TODO: handle exception
				}
				
			}
		});
		Dicionario.setText("Dicionário");
		Dicionario.setFont(new Font("Arial", Font.BOLD, 14));
		Dicionario.setBackground(new Color(204, 204, 255));
		GroupLayout gl_jPanel1 = new GroupLayout(jPanel1);
		gl_jPanel1.setHorizontalGroup(
			gl_jPanel1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jPanel1.createSequentialGroup()
					.addGap(37)
					.addGroup(gl_jPanel1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_jPanel1.createSequentialGroup()
							.addComponent(Cadastrar1, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(Dicionario, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
							.addComponent(Cadastrar, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
							.addGap(19))
						.addGroup(gl_jPanel1.createSequentialGroup()
							.addGroup(gl_jPanel1.createParallelGroup(Alignment.LEADING)
								.addComponent(Peso)
								.addComponent(Idade)
								.addComponent(Nome)
								.addComponent(Sexo)
								.addComponent(Cor1, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_jPanel1.createParallelGroup(Alignment.TRAILING)
								.addComponent(tfSexo, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)
								.addComponent(tfNome, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)
								.addComponent(tfIdade, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)
								.addComponent(tfPeso, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE))
							.addContainerGap(145, Short.MAX_VALUE))))
				.addComponent(jLabel2, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 448, Short.MAX_VALUE)
		);
		gl_jPanel1.setVerticalGroup(
			gl_jPanel1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jPanel1.createSequentialGroup()
					.addGap(10)
					.addComponent(jLabel2)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_jPanel1.createParallelGroup(Alignment.BASELINE)
						.addComponent(Nome, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(tfNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_jPanel1.createParallelGroup(Alignment.BASELINE)
						.addComponent(Peso, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(tfPeso, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_jPanel1.createParallelGroup(Alignment.BASELINE)
						.addComponent(Idade, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(tfIdade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_jPanel1.createParallelGroup(Alignment.BASELINE)
						.addComponent(Sexo, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(tfSexo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_jPanel1.createParallelGroup(Alignment.BASELINE)
						.addComponent(Cor1, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(Cadastrar1, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_jPanel1.createParallelGroup(Alignment.BASELINE)
							.addComponent(Dicionario, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
							.addComponent(Cadastrar, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		jPanel1.setLayout(gl_jPanel1);
	}
}