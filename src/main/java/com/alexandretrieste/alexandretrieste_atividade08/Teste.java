/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.alexandretrieste.alexandretrieste_atividade08;

/**
 *
 * @author xande
 */
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

public class Teste {
    public static void main(String[] args) {
        
        BDVeiculos bdVeiculos = new BDVeiculos();
        Object[] opcoes = {"Passeio", "Carga"};

        boolean menuExt = true;
        while(menuExt) {
            int escolhaInicial = JOptionPane.showOptionDialog(null, "Escolha uma opção:", "Gestão de Veículos", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]
            );
            boolean menuInt = true;
            while(menuInt) {
                if (escolhaInicial == JOptionPane.YES_OPTION) {
                    Object[] opcoesPasseio = {"Cadastrar", "Consultar/Excluir pela placa", "Imprimir/Excluir todos", "Sair"};
                    int escolhaPasseio = JOptionPane.showOptionDialog(null, "Escolha uma opção:", "Veiculos de Passeio", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoesPasseio, opcoesPasseio[0]
                    );
                    switch (escolhaPasseio) {
                        case 0:
                            boolean adicionarNovoVeiculo = true;
                            while (adicionarNovoVeiculo) {
                                JPanel panel = new JPanel();
                                panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
                                panel.add(new JLabel("Placa:"));
                                JTextField placaField = new JTextField();
                                panel.add(placaField);
                                panel.add(new JLabel("Marca:"));
                                JTextField marcaField = new JTextField();
                                panel.add(marcaField);
                                panel.add(new JLabel("Modelo:"));
                                JTextField modeloField = new JTextField();
                                panel.add(modeloField);
                                panel.add(new JLabel("Cor:"));
                                JTextField corField = new JTextField();
                                panel.add(corField);
                                panel.add(new JLabel("Quantidade de Rodas:"));
                                JTextField qtdRodasField = new JTextField();
                                panel.add(qtdRodasField);
                                panel.add(new JLabel("Quantidade de Passageiros:"));
                                JTextField qtdPassageirosField = new JTextField();
                                panel.add(qtdPassageirosField);
                                panel.add(new JLabel("Velocidade Máxima:"));
                                JTextField velocMaxField = new JTextField();
                                panel.add(velocMaxField);
                                panel.add(new JLabel("Potência do Motor:"));
                                JTextField potenciaMotorField = new JTextField();
                                panel.add(potenciaMotorField);
                                panel.add(new JLabel("Quantidade de Pistões do Motor:"));
                                JTextField qtdPistoesMotorField = new JTextField();
                                panel.add(qtdPistoesMotorField);
                                JButton limparButton = new JButton("Limpar");
                                panel.add(limparButton);
                                limparButton.addActionListener(new ActionListener() {
                                    public void actionPerformed(ActionEvent e) {
                                        placaField.setText("");
                                        marcaField.setText("");
                                        modeloField.setText("");
                                        corField.setText("");
                                        qtdRodasField.setText("");
                                        qtdPassageirosField.setText("");
                                        velocMaxField.setText("");
                                        potenciaMotorField.setText("");
                                        qtdPistoesMotorField.setText("");
                                    }
                                });
                                int result = JOptionPane.showConfirmDialog(null, panel, "Cadastro de Passeio", JOptionPane.OK_CANCEL_OPTION);
                                if (result == JOptionPane.OK_OPTION) {
                                    String placa = placaField.getText();
                                    boolean placaExistente = false;
                                    try {
                                        for (Passeio passeio : bdVeiculos.getListaPasseio()) {
                                            if (passeio != null && passeio.getPlaca().equalsIgnoreCase(placa)) {
                                                throw new VeicExistException("passeio", placa);
                                            }
                                        }
                                        String marca = marcaField.getText();
                                        String modelo = modeloField.getText();
                                        String cor = corField.getText();
                                        int qtdRodas = Integer.parseInt(qtdRodasField.getText());
                                        int qtdPassageiros = Integer.parseInt(qtdPassageirosField.getText());
                                        int velocMax = Integer.parseInt(velocMaxField.getText());
                                        try {
                                            if (velocMax < 80 || velocMax > 110) {
                                                throw new VelocException();
                                            }
                                        } catch (VelocException e) {
                                            JOptionPane.showMessageDialog(null, e.getMessage());
                                            velocMax = 100;
                                        }
                                        int potenciaMotor = Integer.parseInt(potenciaMotorField.getText());
                                        int qtdPistoesMotor = Integer.parseInt(qtdPistoesMotorField.getText());
                                        Passeio novoVeiculo = new Passeio(placa, marca, modelo, cor, velocMax, qtdRodas, qtdPassageiros,
                                                potenciaMotor, qtdPistoesMotor);
                                        bdVeiculos.getListaPasseio().add(novoVeiculo);
                                        JOptionPane.showMessageDialog(null, "Veículo de passeio cadastrado com sucesso!");
                                        int resposta = JOptionPane.showOptionDialog(null, "Deseja adicionar um novo veículo?", "Confirmação", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null
                                        );
                                        if (resposta == JOptionPane.YES_OPTION) {
                                            adicionarNovoVeiculo = true;
                                        } else {
                                            adicionarNovoVeiculo = false;
                                        }
                                    } catch (VeicExistException e) {
                                        JOptionPane.showMessageDialog(null, e.getMessage());
                                        break;
                                    }
                                } else if (result == JOptionPane.CANCEL_OPTION) {
                                    break;
                                } else {
                                    menuInt = false;
                                    menuExt = false;
                                    break;
                                }
                            }
                            break;
                        case 1:
                            JPanel panel = new JPanel();
                            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
                            panel.add(new JLabel("Placa:"));
                            JTextField placaField = new JTextField();
                            panel.add(placaField);
                            JTextField marcaField = new JTextField();
                            JTextField modeloField = new JTextField();
                            JTextField corField = new JTextField();
                            JTextField qtdRodasField = new JTextField();
                            JTextField qtdPassageirosField = new JTextField();
                            JTextField velocMaxField = new JTextField();
                            JTextField potenciaMotorField = new JTextField();
                            JTextField qtdPistoesMotorField = new JTextField();
                            marcaField.setEditable(false);
                            modeloField.setEditable(false);
                            corField.setEditable(false);
                            qtdRodasField.setEditable(false);
                            qtdPassageirosField.setEditable(false);
                            velocMaxField.setEditable(false);
                            potenciaMotorField.setEditable(false);
                            qtdPistoesMotorField.setEditable(false);
                            panel.add(new JLabel("Marca:"));
                            panel.add(marcaField);
                            panel.add(new JLabel("Modelo:"));
                            panel.add(modeloField);
                            panel.add(new JLabel("Cor:"));
                            panel.add(corField);
                            panel.add(new JLabel("Quantidade de Rodas:"));
                            panel.add(qtdRodasField);
                            panel.add(new JLabel("Quantidade de Passageiros:"));
                            panel.add(qtdPassageirosField);
                            panel.add(new JLabel("Velocidade Máxima:"));
                            panel.add(velocMaxField);
                            panel.add(new JLabel("Potência do Motor:"));
                            panel.add(potenciaMotorField);
                            panel.add(new JLabel("Quantidade de Pistões do Motor:"));
                            panel.add(qtdPistoesMotorField);
                            panel.setVisible(true);
                            boolean conExc = true;
                            while (conExc) {
                                Object[] options = {"Consultar", "Excluir", "Sair"};
                                int result = JOptionPane.showOptionDialog(null, panel, "Consultar/Excluir pela placa",
                                        JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, null);
                                if (result == JOptionPane.YES_OPTION) {
                                    try {
                                        String placaPasseio = placaField.getText();
                                        boolean encontradoPasseio = false;
                                        for (Passeio passeio : bdVeiculos.getListaPasseio()) {
                                            if (passeio != null && passeio.getPlaca().equalsIgnoreCase(placaPasseio)) {
                                                marcaField.setText(passeio.getMarca());
                                                modeloField.setText(passeio.getModelo());
                                                corField.setText(passeio.getCor());
                                                qtdRodasField.setText(String.valueOf(passeio.getQtdRodas()));
                                                qtdPassageirosField.setText(String.valueOf(passeio.getQtdPassageiros()));
                                                velocMaxField.setText(String.valueOf(passeio.getVelocMax()));
                                                potenciaMotorField.setText(String.valueOf(passeio.getMotor().getPotencia()));
                                                qtdPistoesMotorField.setText(String.valueOf(passeio.getMotor().getQtdPist()));
                                                encontradoPasseio = true;
                                                panel.repaint();
                                            }
                                        }
                                        if (!encontradoPasseio) {
                                            throw new VeicExistException("passeio");
                                        }
                                    } catch (VeicExistException e) {
                                        JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                                    }
                                } else if (result == JOptionPane.NO_OPTION) {
                                    try {
                                        String placaPasseio = placaField.getText();
                                        boolean encontradoPasseio = false;
                                        Iterator<Passeio> iterator = bdVeiculos.getListaPasseio().iterator();
                                        while (iterator.hasNext()) {
                                            Passeio passeio = iterator.next();
                                            if (passeio.getPlaca().equalsIgnoreCase(placaPasseio)) {
                                                iterator.remove();
                                                encontradoPasseio = true;
                                                JOptionPane.showMessageDialog(null, "Veículo removido");
                                            }
                                        }
                                        if (!encontradoPasseio) {
                                            throw new VeicExistException("passeio");
                                        }
                                        marcaField.setText("");
                                        modeloField.setText("");
                                        corField.setText("");
                                        qtdRodasField.setText("");
                                        qtdPassageirosField.setText("");
                                        velocMaxField.setText("");
                                        potenciaMotorField.setText("");
                                        qtdPistoesMotorField.setText("");
                                        panel.repaint();
                                    } catch (VeicExistException e) {
                                        JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                                    }
                                } else if (result == JOptionPane.CANCEL_OPTION) {
                                    break;
                                } else {
                                    menuInt = false;
                                    menuExt = false;
                                    break;
                                }
                            }
                            break;
                        case 2:
                            JTable table = new JTable();
                            DefaultTableModel tableModel = new DefaultTableModel();
                            tableModel.addColumn("Placa");
                            tableModel.addColumn("Marca");
                            tableModel.addColumn("Modelo");
                            tableModel.addColumn("Cor");
                            tableModel.addColumn("Quantidade de Rodas");
                            tableModel.addColumn("Velocidade Máxima");
                            tableModel.addColumn("Quantidade de Pistões do Motor");
                            tableModel.addColumn("Potência do Motor");
                            tableModel.addColumn("Quantidade de Passageiros");
                            table.setModel(tableModel);
                            boolean impExc = true;
                            while (impExc) {
                                Object[] options = {"Consultar Todos", "Excluir Todos", "Sair"};
                                int result = JOptionPane.showOptionDialog(null, new JScrollPane(table), "Imprimir/Excluir Todos",
                                        JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
                                if (result == JOptionPane.YES_OPTION) {
                                    for (Passeio passeio : bdVeiculos.getListaPasseio()) {
                                        if (passeio != null) {
                                            Object[] row = new Object[9];
                                            row[0] = passeio.getPlaca();
                                            row[1] = passeio.getMarca();
                                            row[2] = passeio.getModelo();
                                            row[3] = passeio.getCor();
                                            row[4] = passeio.getQtdRodas();
                                            row[5] = passeio.getVelocMax();
                                            row[6] = passeio.getMotor().getQtdPist();
                                            row[7] = passeio.getMotor().getPotencia();
                                            row[8] = passeio.getQtdPassageiros();
                                            tableModel.addRow(row);
                                        }
                                    }
                                } else if (result == JOptionPane.NO_OPTION) {
                                    bdVeiculos.getListaPasseio().clear();
                                    tableModel.setRowCount(0);
                                } else if (result == JOptionPane.CANCEL_OPTION) {
                                    break;
                                } else {
                                    menuInt = false;
                                    menuExt = false;
                                    break;
                                }
                            }
                            break;
                        case 3:
                            menuInt = false;
                            break;
                        default:
                            menuInt = false;
                            menuExt = false;
                            break;
                    }


                } else if (escolhaInicial == JOptionPane.NO_OPTION) {
                            Object[] opcoesCarga = {"Cadastrar", "Consultar/Excluir pela placa", "Imprimir/Excluir todos", "Sair"};
                            int escolhaCarga = JOptionPane.showOptionDialog(null, "Escolha uma opção:", "Veiculos de Passeio", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoesCarga, opcoesCarga[0]
                            );
                            switch (escolhaCarga) {
                                case 0:
                                    boolean adicionarNovoVeiculo = true;
                                    while (adicionarNovoVeiculo) {
                                        JPanel panel = new JPanel();
                                        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
                                        panel.add(new JLabel("Placa:"));
                                        JTextField placaField = new JTextField();
                                        panel.add(placaField);
                                        panel.add(new JLabel("Marca:"));
                                        JTextField marcaField = new JTextField();
                                        panel.add(marcaField);
                                        panel.add(new JLabel("Modelo:"));
                                        JTextField modeloField = new JTextField();
                                        panel.add(modeloField);
                                        panel.add(new JLabel("Cor:"));
                                        JTextField corField = new JTextField();
                                        panel.add(corField);
                                        panel.add(new JLabel("Quantidade de Rodas:"));
                                        JTextField qtdRodasField = new JTextField();
                                        panel.add(qtdRodasField);
                                        panel.add(new JLabel("Tara:"));
                                        JTextField taraField = new JTextField();
                                        panel.add(taraField);
                                        panel.add(new JLabel("Carga Máxima:"));
                                        JTextField cargaMaximaField = new JTextField();
                                        panel.add(cargaMaximaField);
                                        panel.add(new JLabel("Velocidade Máxima:"));
                                        JTextField velocMaxField = new JTextField();
                                        panel.add(velocMaxField);
                                        panel.add(new JLabel("Potência do Motor:"));
                                        JTextField potenciaMotorField = new JTextField();
                                        panel.add(potenciaMotorField);
                                        panel.add(new JLabel("Quantidade de Pistões do Motor:"));
                                        JTextField qtdPistoesMotorField = new JTextField();
                                        panel.add(qtdPistoesMotorField);
                                        JButton limparButton = new JButton("Limpar");
                                        panel.add(limparButton);
                                        limparButton.addActionListener(new ActionListener() {
                                            public void actionPerformed(ActionEvent e) {
                                                placaField.setText("");
                                                marcaField.setText("");
                                                modeloField.setText("");
                                                corField.setText("");
                                                qtdRodasField.setText("");
                                                taraField.setText("");
                                                cargaMaximaField.setText("");
                                                velocMaxField.setText("");
                                                potenciaMotorField.setText("");
                                                qtdPistoesMotorField.setText("");
                                            }
                                        });
                                        int result = JOptionPane.showConfirmDialog(null, panel, "Cadastro de Veículo de Carga", JOptionPane.OK_CANCEL_OPTION);
                                        if (result == JOptionPane.OK_OPTION) {
                                            String placa = placaField.getText();
                                            boolean placaExistente = false;
                                            try {
                                                for (Carga carga : bdVeiculos.getListaCarga()) {
                                                    if (carga != null && carga.getPlaca().equalsIgnoreCase(placa)) {
                                                        throw new VeicExistException("carga", placa);
                                                    }
                                                }
                                                String marca = marcaField.getText();
                                                String modelo = modeloField.getText();
                                                String cor = corField.getText();
                                                int qtdRodas = Integer.parseInt(qtdRodasField.getText());
                                                int tara = Integer.parseInt(taraField.getText());
                                                int cargaMax = Integer.parseInt(cargaMaximaField.getText());
                                                int velocMax = Integer.parseInt(velocMaxField.getText());
                                                try {
                                                    if (velocMax < 80 || velocMax > 110) {
                                                        throw new VelocException();
                                                    }
                                                } catch (VelocException e) {
                                                    JOptionPane.showMessageDialog(null, e.getMessage());
                                                    velocMax = 90;
                                                }
                                                int potenciaMotor = Integer.parseInt(potenciaMotorField.getText());
                                                int qtdPistoesMotor = Integer.parseInt(qtdPistoesMotorField.getText());
                                                Carga novoVeiculo = new Carga(placa, marca, modelo, cor, velocMax, qtdRodas, tara, cargaMax,
                                                        potenciaMotor, qtdPistoesMotor);
                                                bdVeiculos.getListaCarga().add(novoVeiculo);
                                                JOptionPane.showMessageDialog(null, "Veículo de carga cadastrado com sucesso!");
                                                int resposta = JOptionPane.showOptionDialog(null, "Deseja adicionar um novo veículo?", "Confirmação", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null
                                                );
                                                if (resposta == JOptionPane.YES_OPTION) {
                                                    adicionarNovoVeiculo = true;
                                                } else {
                                                    adicionarNovoVeiculo = false;
                                                }
                                            } catch (VeicExistException e) {
                                                JOptionPane.showMessageDialog(null, e.getMessage());
                                                break;
                                            }
                                        } else if (result == JOptionPane.CANCEL_OPTION) {
                                            break;
                                        } else {
                                            menuInt = false;
                                            menuExt = false;
                                            break;
                                        }
                                    }
                                    break;
                                case 1:
                                    JPanel panel = new JPanel();
                                    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
                                    panel.add(new JLabel("Placa:"));
                                    JTextField placaField = new JTextField();
                                    panel.add(placaField);
                                    JTextField marcaField = new JTextField();
                                    JTextField modeloField = new JTextField();
                                    JTextField corField = new JTextField();
                                    JTextField qtdRodasField = new JTextField();
                                    JTextField taraField = new JTextField();
                                    JTextField cargaMaximaField = new JTextField();
                                    JTextField velocMaxField = new JTextField();
                                    JTextField potenciaMotorField = new JTextField();
                                    JTextField qtdPistoesMotorField = new JTextField();
                                    marcaField.setEditable(false);
                                    modeloField.setEditable(false);
                                    corField.setEditable(false);
                                    qtdRodasField.setEditable(false);
                                    taraField.setEditable(false);
                                    cargaMaximaField.setEditable(false);
                                    velocMaxField.setEditable(false);
                                    potenciaMotorField.setEditable(false);
                                    qtdPistoesMotorField.setEditable(false);
                                    panel.add(new JLabel("Marca:"));
                                    panel.add(marcaField);
                                    panel.add(new JLabel("Modelo:"));
                                    panel.add(modeloField);
                                    panel.add(new JLabel("Cor:"));
                                    panel.add(corField);
                                    panel.add(new JLabel("Quantidade de Rodas:"));
                                    panel.add(qtdRodasField);
                                    panel.add(new JLabel("Tara:"));
                                    panel.add(taraField);
                                    panel.add(new JLabel("Carga Máxima:"));
                                    panel.add(cargaMaximaField);
                                    panel.add(new JLabel("Velocidade Máxima:"));
                                    panel.add(velocMaxField);
                                    panel.add(new JLabel("Potência do Motor:"));
                                    panel.add(potenciaMotorField);
                                    panel.add(new JLabel("Quantidade de Pistões do Motor:"));
                                    panel.add(qtdPistoesMotorField);
                                    panel.setVisible(true);
                                    boolean conExc = true;
                                    while (conExc) {
                                        Object[] options = {"Consultar", "Excluir", "Sair"};
                                        int result = JOptionPane.showOptionDialog(null, panel, "Consultar/Excluir pela placa",
                                                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, null);
                                        if (result == JOptionPane.YES_OPTION) {
                                            try {
                                                String placaCarga = placaField.getText();
                                                boolean encontradoCarga = false;
                                                for (Carga carga : bdVeiculos.getListaCarga()) {
                                                    if (carga != null && carga.getPlaca().equalsIgnoreCase(placaCarga)) {
                                                        marcaField.setText(carga.getMarca());
                                                        modeloField.setText(carga.getModelo());
                                                        corField.setText(carga.getCor());
                                                        qtdRodasField.setText(String.valueOf(carga.getQtdRodas()));
                                                        taraField.setText(String.valueOf(carga.getTara()));
                                                        cargaMaximaField.setText(String.valueOf(carga.getCargaMax()));
                                                        velocMaxField.setText(String.valueOf(carga.getVelocMax()));
                                                        potenciaMotorField.setText(String.valueOf(carga.getMotor().getPotencia()));
                                                        qtdPistoesMotorField.setText(String.valueOf(carga.getMotor().getQtdPist()));
                                                        encontradoCarga = true;
                                                        panel.repaint();
                                                    }
                                                }
                                                if (!encontradoCarga) {
                                                    throw new VeicExistException("carga");
                                                }
                                            } catch (VeicExistException e) {
                                                JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                                            }
                                        } else if (result == JOptionPane.NO_OPTION) {
                                            try {
                                                String placaCarga = placaField.getText();
                                                boolean encontradoCarga = false;
                                                Iterator<Carga> iterator = bdVeiculos.getListaCarga().iterator();
                                                while (iterator.hasNext()) {
                                                    Carga carga = iterator.next();
                                                    if (carga.getPlaca().equalsIgnoreCase(placaCarga)) {
                                                        iterator.remove();
                                                        encontradoCarga = true;
                                                        JOptionPane.showMessageDialog(null, "Veículo removido");
                                                    }
                                                }
                                                if (!encontradoCarga) {
                                                    throw new VeicExistException("carga");
                                                }
                                                marcaField.setText("");
                                                modeloField.setText("");
                                                corField.setText("");
                                                qtdRodasField.setText("");
                                                taraField.setText("");
                                                cargaMaximaField.setText("");
                                                velocMaxField.setText("");
                                                potenciaMotorField.setText("");
                                                qtdPistoesMotorField.setText("");
                                                panel.repaint();
                                            } catch (VeicExistException e) {
                                                JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                                            }
                                        } else if (result == JOptionPane.CANCEL_OPTION) {
                                            break;
                                        } else {
                                            menuInt = false;
                                            menuExt = false;
                                            break;
                                        }
                                    }
                                    break;
                                case 2:
                                    JTable table = new JTable();
                                    DefaultTableModel tableModel = new DefaultTableModel();
                                    tableModel.addColumn("Placa");
                                    tableModel.addColumn("Marca");
                                    tableModel.addColumn("Modelo");
                                    tableModel.addColumn("Cor");
                                    tableModel.addColumn("Quantidade de Rodas");
                                    tableModel.addColumn("Velocidade Máxima");
                                    tableModel.addColumn("Quantidade de Pistões do Motor");
                                    tableModel.addColumn("Potência do Motor");
                                    tableModel.addColumn("Tara");
                                    tableModel.addColumn("Carga Maxima");
                                    table.setModel(tableModel);
                                    boolean impExc = true;
                                    while (impExc) {
                                        Object[] options = {"Consultar Todos", "Excluir Todos", "Sair"};
                                        int result = JOptionPane.showOptionDialog(null, new JScrollPane(table), "Imprimir/Excluir Todos",
                                                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
                                        if (result == JOptionPane.YES_OPTION) {
                                            for (Carga carga : bdVeiculos.getListaCarga()) {
                                                if (carga != null) {
                                                    Object[] row = new Object[10];
                                                    row[0] = carga.getPlaca();
                                                    row[1] = carga.getMarca();
                                                    row[2] = carga.getModelo();
                                                    row[3] = carga.getCor();
                                                    row[4] = carga.getQtdRodas();
                                                    row[5] = carga.getVelocMax();
                                                    row[6] = carga.getMotor().getQtdPist();
                                                    row[7] = carga.getMotor().getPotencia();
                                                    row[8] = carga.getTara();
                                                    row[9] = carga.getCargaMax();
                                                    tableModel.addRow(row);
                                                }
                                            }
                                        } else if (result == JOptionPane.NO_OPTION) {
                                            bdVeiculos.getListaCarga().clear();
                                            tableModel.setRowCount(0);
                                        } else if (result == JOptionPane.CANCEL_OPTION) {
                                            break;
                                        } else {
                                            menuInt = false;
                                            menuExt = false;
                                            break;
                                        }
                                    }
                                    break;
                                case 3:
                                    menuInt = false;
                                    break;
                                default:
                                    menuInt = false;
                                    menuExt = false;
                                    break;
                            }
                    }
                }
        }
    }
}
