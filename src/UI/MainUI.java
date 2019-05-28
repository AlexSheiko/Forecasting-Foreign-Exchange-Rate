package UI;

import feedForward.FFTrain;
import feedForward.FFData;
import feedForward.FForecast;
//import main.FFNeuralNetwork;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
//import sun.awt.image.ToolkitImage;
import java.awt.Graphics;  
 import javax.swing.JPanel;  
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.EventObject;
import java.util.List;
import java.util.Random;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.event.CellEditorListener;
import javax.swing.plaf.ColorUIResource;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.text.Caret;
import javax.swing.text.DefaultCaret;
import javax.swing.text.JTextComponent;
import neuralNetwork.Utility;
import org.apache.http.StatusLine;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import recurrent.RForecast;
import recurrent.RecurrentData;
import recurrent.RecurrentTrain;
import restApi.ApiCaller;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alona Fadieieva
 */
public class MainUI extends javax.swing.JFrame {

    /**
     * Creates new form MainUI
     * 
     * 
     */
    
    private static final int DATE_COL = 0;
    private static final int INPUT_COL = 1;
    private static final int EXPECTED_OUTPUT_COL = 2;
    private static final int ACTUAL_OUTPUT_COL = 3;
 
    public MainUI() {
        try {
            this.iconImage = ImageIO.read(getClass().getResource("/resources/icon.png"));
            setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
            initComponents();  
            rCurrencyComboBox.setVisible(false);
        } catch (IOException ex) {
            Logger.getLogger(MainUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    class MyCustomFilter extends javax.swing.filechooser.FileFilter {
        @Override
        public boolean accept(File file) {
            // Allow only directories, or files with ".txt" extension
            return file.isDirectory() || file.getAbsolutePath().endsWith(".csv");
        }
        @Override
        public String getDescription() {
            // This description will be displayed in the dialog,
            // hard-coded = ugly, should be done via I18N
            return "Text documents (*.csv)";
        }
    } 
    
    class MyfnnListener implements PropertyChangeListener{

        @Override
        public void propertyChange(PropertyChangeEvent evt) {
            if ("progress" == evt.getPropertyName()) {
            int progress = (Integer) evt.getNewValue();
            jProgressBar1.setValue(progress);
//            taskOutput.append(String.format(
//                    "Completed %d%% of task.\n", task.getProgress()));
        } 
        }
    
    }
    
    class MyRnnListener implements PropertyChangeListener{

        @Override
        public void propertyChange(PropertyChangeEvent evt) {
            if ("progress" == evt.getPropertyName()) {
            int progress = (Integer) evt.getNewValue();
            rProgressBar.setValue(progress);
        }
      }
    
    }
    
    
    static MyOwnFocusTraversalPolicy newPolicy;
    private int algo = 1;
    static Image iconImage;

    
    public static void setUIFont (javax.swing.plaf.FontUIResource f){
        java.util.Enumeration keys = UIManager.getDefaults().keys();
        while (keys.hasMoreElements()) {
            Object key = keys.nextElement();
            Object value = UIManager.get (key);
            if (value != null && value instanceof javax.swing.plaf.FontUIResource)
                UIManager.put (key, f);
          }
    } 
    
    public void showNetworkError(){
    }
    
    public void showTodayRate(String[] rate){
   }

    public void calcForecast(String[] rate){}
    
    public void updateHistFile(String[] rate, String fileName) throws FileNotFoundException, IOException{
    }
    
    public Double tmrwForecast(String fileName, int curr){
        return 0.0;
    }
    
    class MyFrame extends javax.swing.JFrame{
         public MyFrame(){
                setUIFont (new javax.swing.plaf.FontUIResource("Segoe UI",Font.PLAIN,13));
            }        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fileChooser = new javax.swing.JFileChooser();
        jFrame1 = new MyFrame();
        jPanel5 = new javax.swing.JPanel();
        submitBtn = new javax.swing.JButton();
        filePath = new java.awt.TextField();
        jButton4 = new javax.swing.JButton();
        testLabel = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        hiddenNeurons = new javax.swing.JSpinner();
        jLabel5 = new javax.swing.JLabel();
        fOutputNeurons = new javax.swing.JSpinner();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        inputNeurons = new javax.swing.JSpinner();
        jProgressBar1 = new JProgressBar(0, 100);
        finishBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        epochInput = new javax.swing.JSpinner();
        jLabel31 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jFrame2 = new MyFrame();
        jPanel7 = new javax.swing.JPanel();
        rSubmitBtn = new javax.swing.JButton();
        rFilePath = new java.awt.TextField();
        jButton6 = new javax.swing.JButton();
        testLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        rHiddenNeurons1 = new javax.swing.JSpinner();
        jLabel12 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        rInputNeurons = new javax.swing.JSpinner();
        rOutputNeurons = new javax.swing.JSpinner();
        rHiddenNeurons2 = new javax.swing.JSpinner();
        rProgressBar = new javax.swing.JProgressBar();
        rFinishBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        rSpinner = new javax.swing.JSpinner();
        jLabel30 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        rCurrencyComboBox = new javax.swing.JSpinner();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel1 = new JPanel()
        {
            protected void paintComponent(Graphics g)
            {
                g.setColor( getBackground() );
                g.fillRect(0, 0, getWidth(), getHeight());
                super.paintComponent(g);
            }
        };
        UIManager.put("TabbedPane.contentAreaColor ",ColorUIResource.BLACK);
        UIManager.put("TabbedPane.selected",ColorUIResource.BLACK);
        UIManager.put("TabbedPane.unselectedBackground",ColorUIResource.BLACK); 
        // UIManager.put("TabbedPane.background",ColorUIResource.BLUE);
        UIManager.put("TabbedPane.shadow",ColorUIResource.BLACK);
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel8 = new JPanel() {
            public void paintComponent(Graphics g) {
                Image img = Toolkit.getDefaultToolkit().getImage(
                    MainUI.class.getResource("/resources/NNImage.jpg"));
                g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
            }
        };  ;
        jPanel10 = new JPanel()
        {
            protected void paintComponent(Graphics g)
            {
                g.setColor( getBackground() );
                g.fillRect(0, 0, getWidth(), getHeight());
                super.paintComponent(g);
            }
        };
        jLabel7 = new javax.swing.JLabel();
        testingDataPath = new JTextField()
        {
            protected void paintComponent(Graphics g)
            {
                g.setColor( getBackground() );
                g.fillRect(0, 0, getWidth(), getHeight());
                super.paintComponent(g);
            }
        };
        testingBrowseBtn = new javax.swing.JToggleButton();
        forecastBtn = new javax.swing.JButton();
        jScrollPane1 = new JScrollPane()
        {
            protected void paintComponent(Graphics g)
            {
                g.setColor( getBackground() );
                g.fillRect(0, 0, getWidth(), getHeight());
                super.paintComponent(g);
            }
        };
        Caret caret = new DefaultCaret()
        {
            public void focusGained(FocusEvent e)
            {
                setVisible(true);
                setSelectionVisible(true);
            }
        };
        caret.setBlinkRate( UIManager.getInt("TextField.caretBlinkRate") );

        JTextField textField = new JTextField();
        textField.setEditable(false);
        textField.setCaret(caret);
        //textField.setBorder(new LineBorder(Color.BLACK));
        // textField.setBackground(Color.BLUE);

        DefaultCellEditor dce = new DefaultCellEditor( textField );
        forecastTable = new JTable();
        jPanel12 = new JPanel()
        {
            protected void paintComponent(Graphics g)
            {
                g.setColor( getBackground() );
                g.fillRect(0, 0, getWidth(), getHeight());
                super.paintComponent(g);
            }
        };
        jPanel13 = new javax.swing.JPanel();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jPanel2 = new JPanel()
        {
            protected void paintComponent(Graphics g)
            {
                g.setColor( getBackground() );
                g.fillRect(0, 0, getWidth(), getHeight());
                super.paintComponent(g);
            }
        };
        doneButton1 = new javax.swing.JButton();
        jPanel30 = new JPanel()
        {
            protected void paintComponent(Graphics g)
            {
                g.setColor( getBackground() );
                g.fillRect(0, 0, getWidth(), getHeight());
                super.paintComponent(g);
            }
        };
        ;
        graphBtn = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        fileChooser.setFileFilter(new MyCustomFilter());

        jFrame1.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jFrame1.setTitle("Параметры тренировки нейронной сети");
        jFrame1.setBackground(new java.awt.Color(102, 102, 102));
        jFrame1.setFocusTraversalPolicyProvider(true);
        jFrame1.setIconImage(iconImage);
        jFrame1.setResizable(false);
        jFrame1.setSize(new java.awt.Dimension(580, 420));

        jPanel5.setBackground(new java.awt.Color(38, 50, 56));
        jPanel5.setAlignmentX(0.0F);
        jPanel5.setAlignmentY(0.0F);
        jPanel5.setPreferredSize(new java.awt.Dimension(480, 480));

        submitBtn.setBackground(new java.awt.Color(0, 204, 0));
        submitBtn.setText("Запуск");
        submitBtn.setOpaque(false);
        submitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitBtnActionPerformed(evt);
            }
        });

        filePath.setText("Data/training.csv");
        filePath.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                filePathFocusGained(evt);
            }
        });
        filePath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filePathActionPerformed(evt);
            }
        });

        jButton4.setText("Изменить...");
        jButton4.setOpaque(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(240, 240, 240));
        jLabel6.setText("Путь к датасету для тренировки:");

        jPanel9.setBackground(new java.awt.Color(51, 51, 51));
        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Введите нейроны", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(240, 240, 240))); // NOI18N
        jPanel9.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jPanel9.setOpaque(false);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(240, 240, 240));
        jLabel3.setLabelFor(inputNeurons);
        jLabel3.setText("Входной слой:");
        jLabel3.setToolTipText("");
        jLabel3.setAlignmentY(0.0F);
        jLabel3.setMaximumSize(new java.awt.Dimension(63, 14));
        jLabel3.setMinimumSize(new java.awt.Dimension(63, 14));
        jLabel3.setPreferredSize(new java.awt.Dimension(63, 14));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(240, 240, 240));
        jLabel4.setText("Скрытый слой:");

        hiddenNeurons.setModel(new javax.swing.SpinnerNumberModel(1, 1, 500, 1));
        JFormattedTextField format2 = ((JSpinner.DefaultEditor) hiddenNeurons.getEditor()).getTextField();
        format2.addFocusListener(fcsListener);
        hiddenNeurons.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        hiddenNeurons.setOpaque(false);

        jLabel5.setForeground(new java.awt.Color(240, 240, 240));
        jLabel5.setText("Выходной слой:");

        fOutputNeurons.setModel(new javax.swing.SpinnerNumberModel(1, null, null, 1));
        JFormattedTextField format3 = ((JSpinner.DefaultEditor) fOutputNeurons.getEditor()).getTextField();
        format3.addFocusListener(fcsListener);
        fOutputNeurons.setEnabled(false);
        fOutputNeurons.setOpaque(false);

        jLabel23.setFont(new java.awt.Font("Kartika", 1, 11)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 153, 102));
        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/ic_info_outline_white_18dp_1x.png"))); // NOI18N
        jLabel23.setToolTipText("<html>Enter number of neurons in input layer<br>equal to number of input.<br>Range 1 - 500</html>");
        jLabel23.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel24.setFont(new java.awt.Font("Kartika", 1, 11)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 153, 102));
        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/ic_info_outline_white_18dp_1x.png"))); // NOI18N
        jLabel24.setToolTipText("<html>Enter number of neurons in<br> hidden layer of neural network.<br>Range 1 - 500</html>");

        jLabel25.setFont(new java.awt.Font("Kartika", 1, 11)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 153, 102));
        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/ic_info_outline_white_18dp_1x.png"))); // NOI18N
        jLabel25.setToolTipText("<html>Number of neurons in output layer<br> of NN, equal to number of output.</html>");

        inputNeurons.setModel(new javax.swing.SpinnerNumberModel(1, 1, 500, 1));
        JFormattedTextField format1 = ((JSpinner.DefaultEditor) inputNeurons.getEditor()).getTextField();
        format1.addFocusListener(fcsListener);
        inputNeurons.setToolTipText("");
        inputNeurons.setOpaque(false);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel23))
                    .addComponent(inputNeurons, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel24))
                    .addComponent(hiddenNeurons))
                .addGap(48, 48, 48)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fOutputNeurons, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel25)))
                .addGap(36, 36, 36))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                            .addComponent(hiddenNeurons)
                            .addComponent(fOutputNeurons))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(inputNeurons))
                .addContainerGap())
        );

        jProgressBar1.setForeground(new java.awt.Color(51, 128, 244));
        jProgressBar1.setStringPainted(true);

        finishBtn.setText("Финиш");
        finishBtn.setEnabled(false);
        finishBtn.setOpaque(false);
        finishBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finishBtnActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setLabelFor(epochInput);
        jLabel1.setText("Количество эпох");

        epochInput.setModel(new javax.swing.SpinnerNumberModel(500, 1, 50000, 500));
        JFormattedTextField format0 = ((JSpinner.DefaultEditor) epochInput.getEditor()).getTextField();
        format0.addFocusListener(fcsListener);
        epochInput.setOpaque(false);

        jLabel31.setFont(new java.awt.Font("Kartika", 1, 11)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 153, 102));
        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/ic_info_outline_white_18dp_1x.png"))); // NOI18N
        jLabel31.setToolTipText("<html>Number of Iteration to train over training data.<br>Range 1 - 50,000</html>");
        jLabel31.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("         :");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(224, 224, 224)
                .addComponent(testLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(49, 49, 49))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(submitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(finishBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabel31)
                            .addGap(82, 82, 82)
                            .addComponent(jLabel14)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(epochInput, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addGap(0, 0, Short.MAX_VALUE))
                                .addComponent(filePath, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(epochInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3))
                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton4)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(2, 2, 2)
                        .addComponent(filePath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(finishBtn)
                    .addComponent(submitBtn))
                .addGap(18, 18, 18)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addComponent(testLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 580, Short.MAX_VALUE)
            .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE))
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 425, Short.MAX_VALUE)
            .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE))
        );

        jFrame1.setLocationRelativeTo(null);

        jFrame2.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        jFrame2.setTitle("Train Recurrent Neural Network");
        jFrame2.setBackground(new java.awt.Color(102, 102, 102));
        jFrame2.setIconImage(iconImage);
        jFrame2.setResizable(false);
        jFrame2.setSize(new java.awt.Dimension(601, 460));

        jPanel7.setBackground(new java.awt.Color(38, 50, 56));
        jPanel7.setAlignmentX(0.0F);
        jPanel7.setAlignmentY(0.0F);
        jPanel7.setFocusCycleRoot(true);
        jPanel7.setFocusTraversalPolicy(newPolicy);
        jPanel7.setPreferredSize(new java.awt.Dimension(590, 460));

        rSubmitBtn.setText("Начать");
        rSubmitBtn.setOpaque(false);
        rSubmitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSubmitBtnActionPerformed(evt);
            }
        });

        rFilePath.setText("Data/training.csv");
        rFilePath.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                rFilePathFocusGained(evt);
            }
        });
        rFilePath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rFilePathActionPerformed(evt);
            }
        });

        jButton6.setText("Изменить...");
        jButton6.setOpaque(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel9.setForeground(new java.awt.Color(240, 240, 240));
        jLabel9.setText("Путь к датасету для тренировки:");

        jPanel11.setBackground(new java.awt.Color(51, 51, 51));
        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Введите нейроны", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel11.setOpaque(false);

        jLabel10.setForeground(new java.awt.Color(240, 240, 240));
        jLabel10.setText("Input Layer:");
        jLabel10.setToolTipText("");
        jLabel10.setAlignmentY(0.0F);
        jLabel10.setMaximumSize(new java.awt.Dimension(63, 14));
        jLabel10.setMinimumSize(new java.awt.Dimension(63, 14));
        jLabel10.setPreferredSize(new java.awt.Dimension(63, 14));

        jLabel11.setForeground(new java.awt.Color(240, 240, 240));
        jLabel11.setText("Скрытый слой:");

        rHiddenNeurons1.setModel(new javax.swing.SpinnerNumberModel(1, 1, 500, 1));
        JFormattedTextField format5 = ((JSpinner.DefaultEditor) rHiddenNeurons1.getEditor()).getTextField();
        format5.addFocusListener(fcsListener);
        rHiddenNeurons1.setNextFocusableComponent(rHiddenNeurons2);
        rHiddenNeurons1.setOpaque(false);

        jLabel12.setForeground(new java.awt.Color(240, 240, 240));
        jLabel12.setText("Выходной слой:");

        jLabel27.setFont(new java.awt.Font("Kartika", 1, 11)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 153, 102));
        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/ic_info_outline_white_18dp_1x.png"))); // NOI18N
        jLabel27.setToolTipText("<html>Enter number of neurons in input layer<br>equal to number of input.<br>Range 1 - 500</html>");
        jLabel27.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel28.setFont(new java.awt.Font("Kartika", 1, 11)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 153, 102));
        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/ic_info_outline_white_18dp_1x.png"))); // NOI18N
        jLabel28.setToolTipText("<html>Enter number of neurons in<br> hidden layer of neural network.<br>Range 1 - 500</html>");

        jLabel29.setFont(new java.awt.Font("Kartika", 1, 11)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 153, 102));
        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/ic_info_outline_white_18dp_1x.png"))); // NOI18N
        jLabel29.setToolTipText("<html>Number of neurons in output layer<br> of NN, equal to number of output.</html>");

        rInputNeurons.setModel(new javax.swing.SpinnerNumberModel(1, 1, 500, 1));
        JFormattedTextField format4 = ((JSpinner.DefaultEditor) rInputNeurons.getEditor()).getTextField();
        format4.addFocusListener(fcsListener);
        rInputNeurons.setNextFocusableComponent(rHiddenNeurons1);
        rInputNeurons.setOpaque(false);

        rOutputNeurons.setModel(new javax.swing.SpinnerNumberModel(1, null, null, 1));
        JFormattedTextField format7 = ((JSpinner.DefaultEditor) rOutputNeurons.getEditor()).getTextField();
        format7.addFocusListener(fcsListener);
        rOutputNeurons.setEnabled(false);
        rOutputNeurons.setNextFocusableComponent(rFilePath);
        rOutputNeurons.setOpaque(false);

        rHiddenNeurons2.setModel(new javax.swing.SpinnerNumberModel(1, 1, 500, 1));
        JFormattedTextField format6 = ((JSpinner.DefaultEditor) rHiddenNeurons2.getEditor()).getTextField();
        format6.addFocusListener(fcsListener);
        rHiddenNeurons2.setNextFocusableComponent(rOutputNeurons);
        rHiddenNeurons2.setOpaque(false);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel27))
                    .addComponent(rInputNeurons, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel28))
                    .addComponent(rHiddenNeurons2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rHiddenNeurons1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel29))
                    .addComponent(rOutputNeurons, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rHiddenNeurons1)
                            .addComponent(rOutputNeurons))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rHiddenNeurons2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(rInputNeurons, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        rProgressBar.setForeground(new java.awt.Color(51, 128, 244));
        rProgressBar.setStringPainted(true);

        rFinishBtn.setText("Финиш");
        rFinishBtn.setEnabled(false);
        rFinishBtn.setOpaque(false);
        rFinishBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rFinishBtnActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setLabelFor(rSpinner);
        jLabel2.setText("Количество эпох");

        rSpinner.setModel(new javax.swing.SpinnerNumberModel(500, 1, 50000, 500));
        JFormattedTextField format8 = ((JSpinner.DefaultEditor) rSpinner.getEditor()).getTextField();
        format8.addFocusListener(fcsListener);
        rSpinner.setOpaque(false);

        jLabel30.setFont(new java.awt.Font("Kartika", 1, 11)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 153, 102));
        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/ic_info_outline_white_18dp_1x.png"))); // NOI18N
        jLabel30.setToolTipText("<html>Number of Iteration to train over training data.<br>Range 1 - 50,000</html>");
        jLabel30.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("          :");

        rCurrencyComboBox.setModel(new javax.swing.SpinnerNumberModel(500, 1, 50000, 500));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(224, 224, 224)
                        .addComponent(testLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(210, 210, 210))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(rSubmitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rFinishBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addComponent(rFilePath, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rProgressBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel30)
                                .addGap(88, 88, 88)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(111, 111, 111)
                                .addComponent(rSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(70, 70, 70))
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                    .addContainerGap(442, Short.MAX_VALUE)
                    .addComponent(rCurrencyComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(71, 71, 71)))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(rSpinner)
                                .addComponent(jLabel13))
                            .addComponent(jLabel2))
                        .addGap(17, 17, 17)
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9))
                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton6)
                    .addComponent(rFilePath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rSubmitBtn)
                    .addComponent(rFinishBtn, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(24, 24, 24)
                .addComponent(rProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(testLabel1)
                .addContainerGap(73, Short.MAX_VALUE))
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addGap(46, 46, 46)
                    .addComponent(rCurrencyComboBox)
                    .addGap(392, 392, 392)))
        );

        javax.swing.GroupLayout jFrame2Layout = new javax.swing.GroupLayout(jFrame2.getContentPane());
        jFrame2.getContentPane().setLayout(jFrame2Layout);
        jFrame2Layout.setHorizontalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 601, Short.MAX_VALUE)
            .addGroup(jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jFrame2Layout.createSequentialGroup()
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 601, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jFrame2Layout.setVerticalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 460, Short.MAX_VALUE)
            .addGroup(jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jFrame2Layout.createSequentialGroup()
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        Vector<Component> order = new Vector<Component>(10);
        order.add(rCurrencyComboBox);
        order.add(format8);
        order.add(format4);
        order.add(format5);
        order.add(format6);
        order.add(rFilePath);
        order.add(jButton6);
        order.add(rSubmitBtn);

        newPolicy = new MyOwnFocusTraversalPolicy(order);
        jPanel7.setFocusTraversalPolicy(newPolicy);

        jFrame2.setLocationRelativeTo(null);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Прогноз обменного курса");
        setIconImage(iconImage);

        jPanel1.setOpaque(false);
        jPanel1.setPreferredSize(new java.awt.Dimension(1360, 610));

        jTabbedPane1.setBackground(new java.awt.Color(204, 204, 204));
        jTabbedPane1.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        jTabbedPane1.setAlignmentX(0.0F);
        jTabbedPane1.setAlignmentY(0.0F);
        jTabbedPane1.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jTabbedPane1.setOpaque(true);

        jPanel10.setBackground(new java.awt.Color(38, 50, 56, 220));
        jPanel10.setDoubleBuffered(false);
        jPanel10.setEnabled(false);
        jPanel10.setFocusable(false);
        jPanel10.setOpaque(false);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Датасет для тестирования:");

        testingDataPath.setBackground(new java.awt.Color(255, 255, 255, 200));
        testingDataPath.setText("Data/testing.csv");
        testingDataPath.setMargin(new java.awt.Insets(2, 4, 2, 2));
        testingDataPath.setOpaque(false);
        testingDataPath.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                testingDataPathFocusGained(evt);
            }
        });
        testingDataPath.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                testingDataPathMouseClicked(evt);
            }
        });
        testingDataPath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                testingDataPathActionPerformed(evt);
            }
        });

        testingBrowseBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        testingBrowseBtn.setText("Изменить...");
        testingBrowseBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                testingBrowseBtnActionPerformed(evt);
            }
        });

        forecastBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        forecastBtn.setText("Спрогнозировать");
        forecastBtn.setOpaque(false);
        forecastBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                forecastBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(testingDataPath, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(testingBrowseBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(forecastBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(testingDataPath, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(testingBrowseBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(forecastBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jScrollPane1.setEnabled(false);
        jScrollPane1.setFocusable(false);
        jScrollPane1.setPreferredSize(new java.awt.Dimension(805, 100));

        //forecastTable.getTableHeader().setOpaque(false);
        //forecastTable.getTableHeader().setBackground(new java.awt.Color(0,150,136,220));
        forecastTable.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        forecastTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"", "", "", ""},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "  Дата", "Вхідні дані", "Очікуваний результат", "Фактичний результат"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        forecastTable.setAlignmentX(20.0F);
        forecastTable.setAlignmentY(20.0F);
        forecastTable.setGridColor(new java.awt.Color(153, 153, 153));
        forecastTable.setIntercellSpacing(new java.awt.Dimension(20, 10));
        forecastTable.setRowHeight(30);
        forecastTable.getTableHeader().setResizingAllowed(false);
        forecastTable.getTableHeader().setReorderingAllowed(false);
        forecastTable.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                forecastTableFocusLost(evt);
            }
        });
        jScrollPane1.setViewportView(forecastTable);
        if (forecastTable.getColumnModel().getColumnCount() > 0) {
            forecastTable.getColumnModel().getColumn(0).setMinWidth(150);
            forecastTable.getColumnModel().getColumn(0).setPreferredWidth(150);
            forecastTable.getColumnModel().getColumn(0).setMaxWidth(150);
            forecastTable.getColumnModel().getColumn(1).setMinWidth(550);
            forecastTable.getColumnModel().getColumn(1).setPreferredWidth(550);
            forecastTable.getColumnModel().getColumn(1).setMaxWidth(550);
            forecastTable.getColumnModel().getColumn(1).setCellEditor(dce);
        }

        jPanel12.setBackground(new java.awt.Color(38, 50, 56, 220));
        jPanel12.setOpaque(false);

        jPanel13.setBackground(new java.awt.Color(56, 56, 56, 180));
        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Выберите алгоритм", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel13.setOpaque(false);

        jRadioButton2.setBackground(new java.awt.Color(56, 56, 56, 180));
        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jRadioButton2.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton2.setText("Рецидивирующая нейронная сеть");
        jRadioButton2.setContentAreaFilled(false);
        jRadioButton2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButton2ItemStateChanged(evt);
            }
        });

        jRadioButton1.setBackground(new java.awt.Color(56, 56, 56, 180));
        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jRadioButton1.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton1.setSelected(true);
        jRadioButton1.setText("Прямая нейронная сеть");
        jRadioButton1.setContentAreaFilled(false);
        jRadioButton1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRadioButton1ItemStateChanged(evt);
            }
        });
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addComponent(jRadioButton1)
                .addGap(102, 102, 102)
                .addComponent(jRadioButton2)
                .addContainerGap(116, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(38, 50, 56, 220));
        jPanel2.setOpaque(false);

        doneButton1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        doneButton1.setText("Натренировать");
        doneButton1.setOpaque(false);
        doneButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                doneButton1MouseClicked(evt);
            }
        });
        doneButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doneButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(doneButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(doneButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        jPanel30.setBackground(new java.awt.Color(38, 50, 56, 220));
        jPanel30.setDoubleBuffered(false);
        jPanel30.setEnabled(false);
        jPanel30.setFocusable(false);
        jPanel30.setOpaque(false);

        graphBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        graphBtn.setText("Граффик");
        graphBtn.setOpaque(false);
        graphBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                graphBtnActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton1.setText("Сбросить");
        jButton1.setOpaque(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(graphBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(graphBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(148, 148, 148)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1089, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(124, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(11, 11, 11)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );

        jTabbedPane1.addTab("Прогноз", jPanel8);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1376, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 614, Short.MAX_VALUE)
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName("Home");

        jScrollPane2.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1371, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 586, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void startFForecast(){
        
        BufferedReader br = null;
        List<Double> inputValues = new ArrayList<Double>();
        String currency = "";
        int currencyCol;
        int inputCnt, hiddenCnt, outputCnt;
        double expectedOutput = 0;
        String tableRowData[] = new String[4];
        Double output;
                
        File testDataFile = new File(testingDataPath.getText());

        currencyCol = 1;
        currency = Utility.getCurrency(currencyCol);
        
        File file = new File("FFresource/" + currency + ".csv");
        FileReader fr;

        String[] cols;
        try {          
            br = new BufferedReader(new FileReader(file));
            cols = br.readLine().split(",");
            inputCnt = Integer.parseInt(cols[0]);
            hiddenCnt = Integer.parseInt(cols[1]);
            outputCnt = Integer.parseInt(cols[2]); 
            br.close();
            try{
                
                File testResultFile = new File("FFresource/testing.txt");
                Files.deleteIfExists(testResultFile.toPath());

                br = new BufferedReader(new FileReader(testDataFile));

                int i=0;
                while(true){
                    readDataFromFile(br, inputCnt, inputValues, currencyCol, tableRowData);  

                    FFData data = new FFData();
                    data.setInputNeurons(inputCnt);
                    data.setHiddenNeurons(hiddenCnt);
                    data.setOutputNeurons(outputCnt);
                    data.setCurrencyCol(currencyCol);
                    data.setInputValues(inputValues);

                    FForecast task = new FForecast(data);
                    output = task.forecast();

                    tableRowData[ACTUAL_OUTPUT_COL] = Utility.formatDecimal(output);
                    fillTable(tableRowData, i);
                    i++;


                    try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("FFresource/testing.txt", true)))) {
                        out.println("intput: " + tableRowData[INPUT_COL]);
                        out.println("Expected Output: " + tableRowData[EXPECTED_OUTPUT_COL]);
                        out.println("Actual: " + output + "\n");
                    }catch (IOException e) {
                        System.err.println(e);
                    }   
                    
                    
                }

                     
            }catch (FileNotFoundException ex) {
                String msg = "File " + testDataFile.getName() + " not found !!";
                JOptionPane.showMessageDialog(Utility.getActiveFrame(),
                msg, "Error", JOptionPane.WARNING_MESSAGE);
                //DialogBox.setVisible(true);
               // Logger.getLogger(MainUI.class.getName()).log(Level.SEVERE, null, ex);
            }catch (NumberFormatException ex) {
               String msg = "Error reading "+ testDataFile.getName() +".\nFormat is not correct !!";
               JOptionPane.showMessageDialog(Utility.getActiveFrame(),
                msg, "Error", JOptionPane.WARNING_MESSAGE);
              //  DialogBox.setVisible(true);
               // Logger.getLogger(MainUI.class.getName()).log(Level.SEVERE, null, ex);
            }catch(EOFException e){
                System.out.println("History data file is completely read.");
            }catch (IOException ex) {
                String msg = "Error reading "+ testDataFile.getName() +" !!";
                JOptionPane.showMessageDialog(Utility.getActiveFrame(),
                msg, "Error", JOptionPane.WARNING_MESSAGE);
               // DialogBox.setVisible(true);
               // Logger.getLogger(MainUI.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
               br.close();
            }
        }catch (FileNotFoundException ex) {
            String msg = "Training weights not found for "+ currency +".\nMake sure neural network is trained !! ";
            JOptionPane.showMessageDialog(Utility.getActiveFrame(),
                msg, "Error", JOptionPane.WARNING_MESSAGE);
            //DialogBox.setVisible(true);
            //Logger.getLogger(MainUI.class.getName()).log(Level.SEVERE, null, ex);
        }catch (IOException ex) {
            String msg = "Error reading weights file for "+ currency +".\nMake sure neural network is trained properly !! ";
            JOptionPane.showMessageDialog(Utility.getActiveFrame(),
                msg, "Error", JOptionPane.WARNING_MESSAGE);
            //DialogBox.setVisible(true);
           // Logger.getLogger(MainUI.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    private void startRForecast(){
        
        BufferedReader br = null;
        List<Double> inputValues = new ArrayList<Double>();
        String currency = "";
        int currencyCol;
        int inputCnt, hiddenCnt1, hiddenCnt2, outputCnt;
        double expectedOutput = 0;
        String tableRowData[] = new String[4];
        Double output;
                
        File testDataFile = new File(testingDataPath.getText());

        currencyCol = 1;
        currency = Utility.getCurrency(currencyCol);
        
        File file = new File("RNNresource/" + currency + ".csv");
        FileReader fr;

        String[] cols;
        try {          
            br = new BufferedReader(new FileReader(file));
            cols = br.readLine().split(",");
            inputCnt = Integer.parseInt(cols[0]);
            hiddenCnt1 = Integer.parseInt(cols[1]);
            hiddenCnt2 = Integer.parseInt(cols[2]);
            outputCnt = Integer.parseInt(cols[3]); 
            br.close();
            try{
                
                File testResultFile = new File("RNNresource/testing.txt");
                Files.deleteIfExists(testResultFile.toPath());

                br = new BufferedReader(new FileReader(testDataFile));

                int i=0;
                while(true){
                    readDataFromFile(br, inputCnt, inputValues, currencyCol, tableRowData);  

                    RecurrentData data = new RecurrentData();
                    data.setInputNeurons(inputCnt);
                    data.setHiddenNeurons1(hiddenCnt1);
                    data.setHiddenNeurons2(hiddenCnt2);
                    data.setOutputNeurons(outputCnt);
                    data.setCurrencyCol(currencyCol);
                    data.setInputValues(inputValues);

                    RForecast task = new RForecast(data);
                    output = task.forecast();

                    tableRowData[ACTUAL_OUTPUT_COL] = Utility.formatDecimal(output);
                    fillTable(tableRowData, i);
                    i++;


                    try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("RNNresource/testing.txt", true)))) {
                        out.println("intput: " + tableRowData[INPUT_COL]);
                        out.println("Expected Output: " + tableRowData[EXPECTED_OUTPUT_COL]);
                        out.println("Actual: " + output + "\n");
                    }catch (IOException e) {
                        System.err.println(e);
                    }              
                    
                }
                     
            }catch (FileNotFoundException ex) {
                String msg = "File " + testDataFile.getName() + " not found !!";
                JOptionPane.showMessageDialog(Utility.getActiveFrame(),
                msg, "Error", JOptionPane.WARNING_MESSAGE);
               // Logger.getLogger(MainUI.class.getName()).log(Level.SEVERE, null, ex);
            }catch (NumberFormatException ex) {
                String msg = "Error reading "+ testDataFile.getName() +".\nFormat is not correct !!";
                JOptionPane.showMessageDialog(Utility.getActiveFrame(),
                msg, "Error", JOptionPane.WARNING_MESSAGE);
               // DialogBox.setVisible(true);
               // Logger.getLogger(MainUI.class.getName()).log(Level.SEVERE, null, ex);
            }catch(EOFException e){
                System.out.println("History data file is completely read.");
            }catch (IOException ex) {
                String msg = "Error reading "+ testDataFile.getName() +" !!";
                JOptionPane.showMessageDialog(Utility.getActiveFrame(),
                msg, "Error", JOptionPane.WARNING_MESSAGE);
               // DialogBox.setVisible(true);
               // Logger.getLogger(MainUI.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
                br.close();
            }
            
        }catch (FileNotFoundException ex) {
            String msg = "Training weights not found for "+ currency +".\nMake sure neural network is trained !! ";
            JOptionPane.showMessageDialog(Utility.getActiveFrame(),
                msg, "Error", JOptionPane.WARNING_MESSAGE);
            //DialogBox.setVisible(true);
            //Logger.getLogger(MainUI.class.getName()).log(Level.SEVERE, null, ex);
        }catch (IOException ex) {
            String msg = "Error reading weights file for "+ currency +".\nMake sure neural network is trained properly !! ";
            JOptionPane.showMessageDialog(Utility.getActiveFrame(),
                msg, "Error", JOptionPane.WARNING_MESSAGE);
            //DialogBox.setVisible(true);
           // Logger.getLogger(MainUI.class.getName()).log(Level.SEVERE, null, ex);
        } 
    
    }
    
    private void fillTable(String[] tableRowData, int row){
        
        DefaultTableModel model = (DefaultTableModel) forecastTable.getModel();
        if(row >= forecastTable.getRowCount())
            model.addRow(new Object[]{"", "", "","", ""});
                
        forecastTable.setValueAt(tableRowData[DATE_COL], row, DATE_COL);
        forecastTable.setValueAt(tableRowData[INPUT_COL], row, INPUT_COL);
        forecastTable.setValueAt(tableRowData[EXPECTED_OUTPUT_COL], row, EXPECTED_OUTPUT_COL);
        forecastTable.setValueAt(tableRowData[ACTUAL_OUTPUT_COL], row, ACTUAL_OUTPUT_COL);
        
    }
    
    private void readDataFromFile(BufferedReader br, int inputCnt, List<Double> inputValues,
            int currencyCol, String[] tableRowData)throws NumberFormatException, EOFException, IOException{
        String line;
        String[] cols;
        int flag = 1;
 
        if(inputValues.size() == 0){
            for (int i = 0; i < inputCnt; i++){
                if((line = br.readLine()) != null) {
                    // use comma as separator
                    cols = line.split(",");
                    inputValues.add(Utility.normalize(Double.parseDouble(cols[currencyCol]),currencyCol));
                } else{
                    throw new EOFException();
                }
            }
        } else{
            //shift every input to left and add previous expected output to last
            //and read expected output from next row.
            inputValues.remove(0);
            inputValues.add(Utility.normalize(Double.parseDouble(tableRowData[EXPECTED_OUTPUT_COL]), currencyCol));
        }

        String str;
        str = "" + Utility.formatDecimal(Utility.denormalize(inputValues.get(0),currencyCol));
        Double d;
        for(int j=1;j<inputValues.size();j++){
            d = inputValues.get(j);
            str += ", " + Utility.formatDecimal(Utility.denormalize(d,currencyCol));
        }
        tableRowData[INPUT_COL] = str;
        
        // Read expected output to display.
        if((line = br.readLine()) != null){
            cols = line.split(",");
            tableRowData[EXPECTED_OUTPUT_COL] = Utility.formatDecimal(Double.parseDouble(cols[currencyCol]));
            tableRowData[DATE_COL] = cols[0];
        } else{
            throw new EOFException();
        }
    }
    
   
    private String chooseFile(){
        int returnVal = fileChooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            return file.getAbsolutePath();
        } else {
            System.out.println("File access cancelled by user.");
            return "";
        }        
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        DefaultTableModel dtm = (DefaultTableModel) forecastTable.getModel();
        dtm.setRowCount(0);
        dtm.setRowCount(4);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void graphBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_graphBtnActionPerformed
        int i = forecastTable.getRowCount();
        int l=0,h=0;
        if(i>30 )
        {
            String[] args = null;
            //        args[0] = (String)CurrencyComboBox.getSelectedItem();
            XYSeriesCollection xySeriesCollection = new XYSeriesCollection();
            XYSeries dataset1 = new XYSeries("expected");
            XYSeries dataset2 = new XYSeries("actual");
            for(int j=0;j<i;j++)
            {
                double f = Double.parseDouble((String)forecastTable.getValueAt(j, 2));
                double g = Double.parseDouble((String)forecastTable.getValueAt(j, 3));
                dataset1.add(j+1,f);
                dataset2.add(j+1,g);
            }
            xySeriesCollection.addSeries(dataset1);
            xySeriesCollection.addSeries(dataset2);
            
            l=45 ;
                h=75 ;
                
            LineChart.main(args, xySeriesCollection,l,h);
        }
        else
        {
            String msg = "Forecast Exchange Rate First!!";
            JOptionPane.showMessageDialog(Utility.getActiveFrame(),
                msg, "Error", JOptionPane.WARNING_MESSAGE);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_graphBtnActionPerformed

    private void doneButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doneButton1ActionPerformed

    }//GEN-LAST:event_doneButton1ActionPerformed

    private void doneButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_doneButton1MouseClicked
        // TODO add your handling code here:
        if(algo == 1){
            jFrame1.pack();
            jFrame1.setVisible(true);
        }
        else if(algo == 2){
            jFrame2.pack();
            jFrame2.setVisible(true);
        }

    }//GEN-LAST:event_doneButton1MouseClicked

    private void jRadioButton1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButton1ItemStateChanged
        // TODO add your handling code here:
        algo = 1;
    }//GEN-LAST:event_jRadioButton1ItemStateChanged

    private void jRadioButton2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButton2ItemStateChanged
        // TODO add your handling code here:
        algo = 2;
    }//GEN-LAST:event_jRadioButton2ItemStateChanged

    private void forecastTableFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_forecastTableFocusLost
        forecastTable.getSelectionModel().clearSelection();
    }//GEN-LAST:event_forecastTableFocusLost

    private void forecastBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_forecastBtnActionPerformed
        setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DefaultTableModel dtm = (DefaultTableModel) forecastTable.getModel();
        dtm.setRowCount(0);
        dtm.setRowCount(4);

        if(algo == 1){
            startFForecast();
        }else{
            startRForecast();
        }

        setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_forecastBtnActionPerformed

    private void testingBrowseBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_testingBrowseBtnActionPerformed
        int returnVal = fileChooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            testingDataPath.setText(file.getAbsolutePath());
        } else {
            System.out.println("File access cancelled by user.");
        }
    }//GEN-LAST:event_testingBrowseBtnActionPerformed

    private void testingDataPathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_testingDataPathActionPerformed
        // TODO add your handling code here:
        testingDataPath.selectAll();
    }//GEN-LAST:event_testingDataPathActionPerformed

    private void testingDataPathMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_testingDataPathMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_testingDataPathMouseClicked

    private void testingDataPathFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_testingDataPathFocusGained
        // TODO add your handling code here:
        testingDataPath.selectAll();
    }//GEN-LAST:event_testingDataPathFocusGained

    private void finishBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finishBtnActionPerformed
        // TODO add your handling code here:
        jFrame1.dispose();
    }//GEN-LAST:event_finishBtnActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        filePath.setText(chooseFile());
    }//GEN-LAST:event_jButton4ActionPerformed

    private void filePathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filePathActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_filePathActionPerformed

    private void filePathFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_filePathFocusGained
        // TODO add your handling code here:
        filePath.selectAll();
    }//GEN-LAST:event_filePathFocusGained

    private void submitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitBtnActionPerformed
        // TODO add your handling code here:

        submitBtn.setEnabled(false);
        finishBtn.setEnabled(false);
        setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));

        double minErrorCondition = 0.01;

        FFData data = new FFData();

        data.setCurrencyCol(1);
        data.setInputNeurons((Integer) inputNeurons.getValue());
        data.setHiddenNeurons((Integer) hiddenNeurons.getValue());
        data.setOutputNeurons((Integer) fOutputNeurons.getValue());
        data.setFilePath(filePath.getText());
        data.setEpoch((Integer) epochInput.getValue());
        data.setMinError(minErrorCondition);
        data.setContext(this);

        FFTrain task = new FFTrain(data);
        task.addPropertyChangeListener(new MyfnnListener());
        task.execute();

    }//GEN-LAST:event_submitBtnActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void rFinishBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rFinishBtnActionPerformed
        jFrame2.dispose();
    }//GEN-LAST:event_rFinishBtnActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        rFilePath.setText(chooseFile());
    }//GEN-LAST:event_jButton6ActionPerformed

    private void rFilePathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rFilePathActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rFilePathActionPerformed

    private void rFilePathFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_rFilePathFocusGained
        // TODO add your handling code here:
        rFilePath.selectAll();
    }//GEN-LAST:event_rFilePathFocusGained

    private void rSubmitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSubmitBtnActionPerformed
        rSubmitBtn.setEnabled(false);
        rFinishBtn.setEnabled(false);
        setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));

        double minErrorCondition = 0.01;

        RecurrentData data = new RecurrentData();

        data.setCurrencyCol(1);
        data.setInputNeurons((Integer) rInputNeurons.getValue());
        data.setHiddenNeurons1((Integer) rHiddenNeurons1.getValue());
        data.setHiddenNeurons2((Integer) rHiddenNeurons2.getValue());
        data.setOutputNeurons((Integer) rOutputNeurons.getValue());
        data.setFilePath(rFilePath.getText());
        data.setEpoch((Integer)rSpinner.getValue());
        data.setMinError(minErrorCondition);
        data.setContext(this);

        RecurrentTrain task = new RecurrentTrain(data);
        task.addPropertyChangeListener(new MyRnnListener());
        task.execute();
    }//GEN-LAST:event_rSubmitBtnActionPerformed

    private FocusListener fcsListener = new FocusListener() {
        @Override
        public void focusGained(FocusEvent e) {
            dumpInfo(e);
        }

        @Override
        public void focusLost(FocusEvent e) {
            dumpInfo(e);
        }

        private void dumpInfo(FocusEvent e) {
          
            final Component c = e.getComponent();
            if (c instanceof JFormattedTextField) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        ((JFormattedTextField) c).setText(((JFormattedTextField) c).getText());
                        ((JFormattedTextField) c).selectAll();
                    }
                });
            } 
        }

        private String name(Component c) {
            return (c == null) ? null : c.getName();
        }
        
    };
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                MainUI frame = new MainUI();
                frame.setVisible(true); 
                ApiCaller task = new ApiCaller(frame);
                task.execute();
            }
        });
    }

    public JButton getrFinishBtn() {
        return rFinishBtn;
    }

    public JButton getrSubmitBtn() {
        return rSubmitBtn;
    }
    
    public JButton getFinishBtn() {
        return finishBtn;
    }

    public JButton getSubmitBtn() {
        return submitBtn;
    }
      

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton doneButton1;
    private javax.swing.JSpinner epochInput;
    private javax.swing.JSpinner fOutputNeurons;
    private javax.swing.JFileChooser fileChooser;
    private java.awt.TextField filePath;
    private javax.swing.JButton finishBtn;
    private javax.swing.JButton forecastBtn;
    private javax.swing.JTable forecastTable;
    private javax.swing.JButton graphBtn;
    private javax.swing.JSpinner hiddenNeurons;
    private javax.swing.JSpinner inputNeurons;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JFrame jFrame2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JSpinner rCurrencyComboBox;
    private java.awt.TextField rFilePath;
    private javax.swing.JButton rFinishBtn;
    private javax.swing.JSpinner rHiddenNeurons1;
    private javax.swing.JSpinner rHiddenNeurons2;
    private javax.swing.JSpinner rInputNeurons;
    private javax.swing.JSpinner rOutputNeurons;
    private javax.swing.JProgressBar rProgressBar;
    private javax.swing.JSpinner rSpinner;
    private javax.swing.JButton rSubmitBtn;
    private javax.swing.JButton submitBtn;
    private javax.swing.JLabel testLabel;
    private javax.swing.JLabel testLabel1;
    private javax.swing.JToggleButton testingBrowseBtn;
    private javax.swing.JTextField testingDataPath;
    // End of variables declaration//GEN-END:variables
}
