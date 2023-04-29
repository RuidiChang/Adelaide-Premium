package com.store.ui;

import com.store.dao.CatalogDao;
import com.store.dao.GoodsDao;
import com.store.dao.OrderDao;
import com.store.entity.Catalog;
import com.store.entity.Order;
import com.store.util.Tools;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.chart.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.TextFlow;
import javafx.scene.control.Label;
import javax.xml.soap.Text;
import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import java.util.*;

/**
 * generate the monthly top 10 items of each type as required
 */
public class Top10Report implements Initializable {
    /**
     * The Ui top 10.
     */
    @FXML
    private Pane ui_top10;

    /**
     * The Label.
     */
    @FXML
    private Label label;

    /**
     * The Label 2.
     */
    @FXML
    private Label label2;

    /**
     * The Label 3.
     */
    @FXML
    private Label label3;

    /**
     * The Pie chart.
     */
    @FXML
    public PieChart pieChart;


    /**
     * Click return menu.
     *
     * @param actionEvent the action event
     * @throws Exception the exception
     */
    @FXML
    protected void click_return_menu(MouseEvent actionEvent) throws Exception {
        Pane other = FXMLLoader.load(getClass().getResource("/com/store/ui/sample.fxml"));
        ((Button) actionEvent.getSource()).getScene().setRoot(other);
    }

    /**
     * The Ssum.
     */
    int ssum=0, /**
     * The Tsum.
     */
    tsum=0, /**
     * The Jsum.
     */
    jsum=0;

    /**
     * Click check shirt.
     *
     * @param actionEvent the action event
     * @throws Exception the exception
     */
    @FXML
    protected void click_check_shirt(MouseEvent actionEvent) throws Exception {
        List<Catalog> s1001 = CatalogDao.findCatalog(null,"s1001");
        List<Catalog> s1002 = CatalogDao.findCatalog(null,"s1002");
        List<Catalog> s1003 = CatalogDao.findCatalog(null,"s1003");
        List<Catalog> s1004 = CatalogDao.findCatalog(null,"s1004");
        List<Catalog> s1005 = CatalogDao.findCatalog(null,"s1005");
        List<Catalog> s1006 = CatalogDao.findCatalog(null,"s1006");
        List<Catalog> s1007 = CatalogDao.findCatalog(null,"s1007");
        List<Catalog> s1008 = CatalogDao.findCatalog(null,"s1008");
        List<Catalog> s1009 = CatalogDao.findCatalog(null,"s1009");
        List<Catalog> s1010 = CatalogDao.findCatalog(null,"s1010");
        List<Catalog> s1011 = CatalogDao.findCatalog(null,"s1011");
        List<Catalog> s1012 = CatalogDao.findCatalog(null,"s1012");
        List<Catalog> s1013 = CatalogDao.findCatalog(null,"s1013");
        List<Catalog> s1014 = CatalogDao.findCatalog(null,"s1014");
        List<Catalog> s1015 = CatalogDao.findCatalog(null,"s1015");
        List<Catalog> s1016 = CatalogDao.findCatalog(null,"s1016");

  


        int s1=0,s2=0,s3=0,s4=0,s5=0,s6=0,s7=0,s8=0,s9=0,s10=0,s11=0,s12=0,s13=0,s14=0,s15=0,s16=0;
        LocalDate now = LocalDate.now().minus(1, ChronoUnit.MONTHS);
        Date date1 = Date.from(now.atStartOfDay(ZoneOffset.ofHours(8)).toInstant());

        for(Catalog catalog: s1001){
            List<Order> orders=OrderDao.findOrder(null, catalog.getCatalog_id(),null,null );
            for(Order order:orders){
                if(order.getDate().compareTo(date1) > 0){
                    s1++;
                }
            }
        }
        String s001=s1+"";

        for(Catalog catalog: s1002){
            List<Order> orders=OrderDao.findOrder(null, catalog.getCatalog_id(),null,null );
            for(Order order:orders){
                if(order.getDate().compareTo(date1) > 0){
                    s2++;
                }
            }
        }
        String s002=s2+"";

        for(Catalog catalog: s1003){
            List<Order> orders=OrderDao.findOrder(null, catalog.getCatalog_id(),null,null );
            for(Order order:orders){
                if(order.getDate().compareTo(date1) > 0){
                    s3++;
                }
            }
        }
        String s003=s3+"";
        
        for(Catalog catalog: s1004){
            List<Order> orders=OrderDao.findOrder(null, catalog.getCatalog_id(),null,null );
            for(Order order:orders){
                if(order.getDate().compareTo(date1) > 0){
                    s4++;
                }
            }
        }
        String s004=s4+"";
        
        for(Catalog catalog: s1005){
            List<Order> orders=OrderDao.findOrder(null, catalog.getCatalog_id(),null,null );
            for(Order order:orders){
                if(order.getDate().compareTo(date1) > 0){
                    s5++;
                }
            }
        }
        String s005=s5+"";
        
        for(Catalog catalog: s1006){
            List<Order> orders=OrderDao.findOrder(null, catalog.getCatalog_id(),null,null );
            for(Order order:orders){
                if(order.getDate().compareTo(date1) > 0){
                    s6++;
                }
            }
        }
        String s006=s6+"";
        
        for(Catalog catalog: s1007){
            List<Order> orders=OrderDao.findOrder(null, catalog.getCatalog_id(),null,null );
            for(Order order:orders){
                if(order.getDate().compareTo(date1) > 0){
                    s7++;
                }
            }
        }
        String s007=s7+"";
        
        for(Catalog catalog: s1008){
            List<Order> orders=OrderDao.findOrder(null, catalog.getCatalog_id(),null,null );
            for(Order order:orders){
                if(order.getDate().compareTo(date1) > 0){
                    s8++;
                }
            }
        }
        String s008=s8+"";

        for(Catalog catalog: s1009){
            List<Order> orders=OrderDao.findOrder(null, catalog.getCatalog_id(),null,null );
            for(Order order:orders){
                if(order.getDate().compareTo(date1) > 0){
                    s9++;
                }
            }
        }
        String s009=s9+"";

        for(Catalog catalog: s1010){
            List<Order> orders=OrderDao.findOrder(null, catalog.getCatalog_id(),null,null );
            for(Order order:orders){
                if(order.getDate().compareTo(date1) > 0){
                    s10++;
                }
            }
        }
        String s010=s10+"";

        for(Catalog catalog: s1011){
            List<Order> orders=OrderDao.findOrder(null, catalog.getCatalog_id(),null,null );
            for(Order order:orders){
                if(order.getDate().compareTo(date1) > 0){
                    s11++;
                }
            }
        }
        String s011=s11+"";

        for(Catalog catalog: s1012){
            List<Order> orders=OrderDao.findOrder(null, catalog.getCatalog_id(),null,null );
            for(Order order:orders){
                if(order.getDate().compareTo(date1) > 0){
                    s12++;
                }
            }
        }
        String s012=s12+"";

        for(Catalog catalog: s1013){
            List<Order> orders=OrderDao.findOrder(null, catalog.getCatalog_id(),null,null );
            for(Order order:orders){
                if(order.getDate().compareTo(date1) > 0){
                    s13++;
                }
            }
        }
        String s013=s13+"";
        
        for(Catalog catalog: s1014){
            List<Order> orders=OrderDao.findOrder(null, catalog.getCatalog_id(),null,null );
            for(Order order:orders){
                if(order.getDate().compareTo(date1) > 0){
                    s14++;
                }
            }
        }
        String s014=s14+"";


        for(Catalog catalog: s1015){
            List<Order> orders=OrderDao.findOrder(null, catalog.getCatalog_id(),null,null );
            for(Order order:orders){
                if(order.getDate().compareTo(date1) > 0){
                    s15++;
                }
            }
        }
        String s015=s15+"";


        for(Catalog catalog: s1016){
            List<Order> orders=OrderDao.findOrder(null, catalog.getCatalog_id(),null,null );
            for(Order order:orders){
                if(order.getDate().compareTo(date1) > 0){
                    s16++;
                }
            }
        }
        String s016=s16+"";

        
        ssum=s1+ s2+ s3+ s4+ s5+ s6+ s7+ s8+ s9+ s10+ s11+ s12+ s13+ s14+ s15+ s16;
        int sarr[] = {s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, s12, s13, s14, s15, s16};
        String ssarr[]={"s1001", "s1002", "s1003", "s1004", "s1005", "s1006", "s1007", "s1008", "s1009", "s1010", "s1011", "s1012", "s1013", "s1014", "s1015", "s1016"};

        for (int i = 0; i < sarr.length; i++) {
            for (int j = 0; j < sarr.length - i - 1; j++) {
                if (sarr[j] < sarr[j + 1]) {
                    int temp = sarr[j + 1];
                    sarr[j + 1] = sarr[j];
                    sarr[j] = temp;
                    String stemp=ssarr[j+1];
                    ssarr[j + 1] = ssarr[j];
                    ssarr[j] = stemp;
                }
            }
        }

        String sout=ssarr[0]+", "+ssarr[1]+", "+ssarr[3]+", "+ssarr[4]+", "+ssarr[5]+", "+ssarr[6]+", "+ssarr[7]+", "+ssarr[8]+", "+ssarr[9];
        System.out.println(sout);
        label.setText(sout);

        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                        new PieChart.Data("s1001", s1),
                        new PieChart.Data("s1002", s2),
                        new PieChart.Data("s1003", s3),
                        new PieChart.Data("s1004", s4),
                        new PieChart.Data("s1005", s5),
                        new PieChart.Data("s1006", s6),
                        new PieChart.Data("s1007", s7),
                        new PieChart.Data("s1008", s8),
                        new PieChart.Data("s1009", s9),
                        new PieChart.Data("s1010", s10),
                        new PieChart.Data("s1011", s11),
                        new PieChart.Data("s1012", s12),
                        new PieChart.Data("s1013", s13),
                        new PieChart.Data("s1014", s14),
                        new PieChart.Data("s1015", s15),
                        new PieChart.Data("s1016",s16));
        pieChart.setData(pieChartData);
    }

    /**
     * Click check trouser.
     *
     * @param actionEvent the action event
     * @throws Exception the exception
     */
    @FXML
    protected void click_check_trouser(MouseEvent actionEvent) throws Exception {
        List<Catalog> t1001 = CatalogDao.findCatalog(null,"t1001");
        List<Catalog> t1002 = CatalogDao.findCatalog(null,"t1002");
        List<Catalog> t1003 = CatalogDao.findCatalog(null,"t1003");
        List<Catalog> t1004 = CatalogDao.findCatalog(null,"t1004");
        List<Catalog> t1005 = CatalogDao.findCatalog(null,"t1005");
        List<Catalog> t1006 = CatalogDao.findCatalog(null,"t1006");
        List<Catalog> t1007 = CatalogDao.findCatalog(null,"t1007");
        List<Catalog> t1008 = CatalogDao.findCatalog(null,"t1008");
        List<Catalog> t1009 = CatalogDao.findCatalog(null,"t1009");
        List<Catalog> t1010 = CatalogDao.findCatalog(null,"t1010");
        List<Catalog> t1011 = CatalogDao.findCatalog(null,"t1011");
        List<Catalog> t1012 = CatalogDao.findCatalog(null,"t1012");
        List<Catalog> t1013 = CatalogDao.findCatalog(null,"t1013");
        List<Catalog> t1014 = CatalogDao.findCatalog(null,"t1014");
        List<Catalog> t1015 = CatalogDao.findCatalog(null,"t1015");

        int t1=0,t2=0,t3=0,t4=0,t5=0,t6=0,t7=0,t8=0,t9=0,t10=0,t11=0,t12=0,t13=0,t14=0,t15=0;
        LocalDate now = LocalDate.now().minus(1, ChronoUnit.MONTHS);
        Date date1 = Date.from(now.atStartOfDay(ZoneOffset.ofHours(8)).toInstant());

        for(Catalog catalog: t1001){
            List<Order> orders=OrderDao.findOrder(null, catalog.getCatalog_id(),null,null );
            for(Order order:orders){
                if(order.getDate().compareTo(date1) > 0){
                    t1++;
                }
            }
        }
        String t001=t1+"";

        for(Catalog catalog: t1002){
            List<Order> orders=OrderDao.findOrder(null, catalog.getCatalog_id(),null,null );
            for(Order order:orders){
                if(order.getDate().compareTo(date1) > 0){
                    t2++;
                }
            }
        }
        String t002=t2+"";

        for(Catalog catalog: t1003){
            List<Order> orders=OrderDao.findOrder(null, catalog.getCatalog_id(),null,null );
            for(Order order:orders){
                if(order.getDate().compareTo(date1) > 0){
                    t3++;
                }
            }
        }
        String t003=t3+"";

        for(Catalog catalog: t1004){
            List<Order> orders=OrderDao.findOrder(null, catalog.getCatalog_id(),null,null );
            for(Order order:orders){
                if(order.getDate().compareTo(date1) > 0){
                    t4++;
                }
            }
        }
        String t004=t4+"";

        for(Catalog catalog: t1005){
            List<Order> orders=OrderDao.findOrder(null, catalog.getCatalog_id(),null,null );
            for(Order order:orders){
                if(order.getDate().compareTo(date1) > 0){
                    t5++;
                }
            }
        }
        String t005=t5+"";
        
        for(Catalog catalog: t1006){
            List<Order> orders=OrderDao.findOrder(null, catalog.getCatalog_id(),null,null );
            for(Order order:orders){
                if(order.getDate().compareTo(date1) > 0){
                    t6++;
                }
            }
        }
        String t006=t6+"";

        for(Catalog catalog: t1007){
            List<Order> orders=OrderDao.findOrder(null, catalog.getCatalog_id(),null,null );
            for(Order order:orders){
                if(order.getDate().compareTo(date1) > 0){
                    t7++;
                }
            }
        }
        String t007=t7+"";
        
        for(Catalog catalog: t1008){
            List<Order> orders=OrderDao.findOrder(null, catalog.getCatalog_id(),null,null );
            for(Order order:orders){
                if(order.getDate().compareTo(date1) > 0){
                    t8++;
                }
            }
        }
        String t008=t8+"";
        
        for(Catalog catalog: t1009){
            List<Order> orders=OrderDao.findOrder(null, catalog.getCatalog_id(),null,null );
            for(Order order:orders){
                if(order.getDate().compareTo(date1) > 0){
                    t9++;
                }
            }
        }
        String t009=t9+"";

        for(Catalog catalog: t1010){
            List<Order> orders=OrderDao.findOrder(null, catalog.getCatalog_id(),null,null );
            for(Order order:orders){
                if(order.getDate().compareTo(date1) > 0){
                    t10++;
                }
            }
        }
        String t010=t10+"";

        for(Catalog catalog: t1011){
            List<Order> orders=OrderDao.findOrder(null, catalog.getCatalog_id(),null,null );
            for(Order order:orders){
                if(order.getDate().compareTo(date1) > 0){
                    t11++;
                }
            }
        }
        String t011=t11+"";

        for(Catalog catalog: t1012){
            List<Order> orders=OrderDao.findOrder(null, catalog.getCatalog_id(),null,null );
            for(Order order:orders){
                if(order.getDate().compareTo(date1) > 0){
                    t12++;
                }
            }
        }
        String t012=t12+"";

        for(Catalog catalog: t1013){
            List<Order> orders=OrderDao.findOrder(null, catalog.getCatalog_id(),null,null );
            for(Order order:orders){
                if(order.getDate().compareTo(date1) > 0){
                    t13++;
                }
            }
        }
        String t013=t13+"";

        for(Catalog catalog: t1014){
            List<Order> orders=OrderDao.findOrder(null, catalog.getCatalog_id(),null,null );
            for(Order order:orders){
                if(order.getDate().compareTo(date1) > 0){
                    t14++;
                }
            }
        }
        String t014=t14+"";

        for(Catalog catalog: t1015){
            List<Order> orders=OrderDao.findOrder(null, catalog.getCatalog_id(),null,null );
            for(Order order:orders){
                if(order.getDate().compareTo(date1) > 0){
                    t15++;
                }
            }
        }
        String t015=t15+"";
        
        tsum=t1+ t2+ t3+ t4+ t5+ t6+ t7+ t8+ t9+ t10+ t11+ t12+ t13+ t14+ t15;

        int tarr[] = {t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15};
        String ttarr[]={"t1001", "t1002", "t1003", "t1004", "t1005", "t1006", "t1007", "t1008", "t1009", "t1010", "t1011", "t1012", "t1013", "t1014", "t1015"};

        for (int i = 0; i < tarr.length; i++) {
            for (int j = 0; j < tarr.length - i - 1; j++) {
                if (tarr[j] < tarr[j + 1]) {
                    int temp = tarr[j + 1];
                    tarr[j + 1] = tarr[j];
                    tarr[j] = temp;
                    String ttemp=ttarr[j+1];
                    ttarr[j + 1] = ttarr[j];
                    ttarr[j] = ttemp;
                }
            }
        }

        String tout=ttarr[0]+", "+ttarr[1]+", "+ttarr[3]+", "+ttarr[4]+", "+ttarr[5]+", "+ttarr[6]+", "+ttarr[7]+", "+ttarr[8]+", "+ttarr[9];
        System.out.println(tout);
        label2.setText(tout);

        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                        new PieChart.Data("t1001", t1),
                        new PieChart.Data("t1002", t2),
                        new PieChart.Data("t1003", t3),
                        new PieChart.Data("t1004", t4),
                        new PieChart.Data("t1005", t5),
                        new PieChart.Data("t1006", t6),
                        new PieChart.Data("t1007", t7),
                        new PieChart.Data("t1008", t8),
                        new PieChart.Data("t1009", t9),
                        new PieChart.Data("t1010", t10),
                        new PieChart.Data("t1011", t11),
                        new PieChart.Data("t1012", t12),
                        new PieChart.Data("t1013", t13),
                        new PieChart.Data("t1014", t14),
                        new PieChart.Data("t1015", t15));
        pieChart.setData(pieChartData);

    }

    /**
     * Click check jacket.
     *
     * @param actionEvent the action event
     * @throws Exception the exception
     */
    @FXML
    protected void click_check_jacket(MouseEvent actionEvent) throws Exception {
        List<Catalog> j1001 = CatalogDao.findCatalog(null,"j1001");
        List<Catalog> j1002 = CatalogDao.findCatalog(null,"j1002");
        List<Catalog> j1003 = CatalogDao.findCatalog(null,"j1003");
        List<Catalog> j1004 = CatalogDao.findCatalog(null,"j1004");
        List<Catalog> j1005 = CatalogDao.findCatalog(null,"j1005");
        List<Catalog> j1006 = CatalogDao.findCatalog(null,"j1006");
        List<Catalog> j1007 = CatalogDao.findCatalog(null,"j1007");
        List<Catalog> j1008 = CatalogDao.findCatalog(null,"j1008");
        List<Catalog> j1009 = CatalogDao.findCatalog(null,"j1009");
        List<Catalog> j1010 = CatalogDao.findCatalog(null,"j1010");
        List<Catalog> j1011 = CatalogDao.findCatalog(null,"j1011");
        List<Catalog> j1012 = CatalogDao.findCatalog(null,"j1012");
        List<Catalog> j1013 = CatalogDao.findCatalog(null,"j1013");
        List<Catalog> j1014 = CatalogDao.findCatalog(null,"j1014");
        List<Catalog> j1015 = CatalogDao.findCatalog(null,"j1015");
        List<Catalog> j1016 = CatalogDao.findCatalog(null,"j1016");
        List<Catalog> j1017 = CatalogDao.findCatalog(null,"j1017");

        int j1=0,j2=0,j3=0,j4=0,j5=0,j6=0,j7=0,j8=0,j9=0,j10=0,j11=0,j12=0,j13=0,j14=0,j15=0,j16=0,j17=0;
        LocalDate now = LocalDate.now().minus(1, ChronoUnit.MONTHS);
        Date date1 = Date.from(now.atStartOfDay(ZoneOffset.ofHours(8)).toInstant());
        
        for(Catalog catalog: j1001){
            List<Order> orders=OrderDao.findOrder(null, catalog.getCatalog_id(),null,null );
            for(Order order:orders){
                if(order.getDate().compareTo(date1) > 0){
                    j1++;
                }
            }
        }
        String j001=j1+"";

        for(Catalog catalog: j1002){
            List<Order> orders=OrderDao.findOrder(null, catalog.getCatalog_id(),null,null );
            for(Order order:orders){
                if(order.getDate().compareTo(date1) > 0){
                    j2++;
                }
            }
        }
        String j002=j2+"";

        for(Catalog catalog: j1003){
            List<Order> orders=OrderDao.findOrder(null, catalog.getCatalog_id(),null,null );
            for(Order order:orders){
                if(order.getDate().compareTo(date1) > 0){
                    j3++;
                }
            }
        }
        String j003=j3+"";
        
        for(Catalog catalog: j1004){
            List<Order> orders=OrderDao.findOrder(null, catalog.getCatalog_id(),null,null );
            for(Order order:orders){
                if(order.getDate().compareTo(date1) > 0){
                    j4++;
                }
            }
        }
        String j004=j4+"";

        for(Catalog catalog: j1005){
            List<Order> orders=OrderDao.findOrder(null, catalog.getCatalog_id(),null,null );
            for(Order order:orders){
                if(order.getDate().compareTo(date1) > 0){
                    j5++;
                }
            }
        }
        String j005=j5+"";
        
        for(Catalog catalog: j1006){
            List<Order> orders=OrderDao.findOrder(null, catalog.getCatalog_id(),null,null );
            for(Order order:orders){
                if(order.getDate().compareTo(date1) > 0){
                    j6++;
                }
            }
        }
        String j006=j6+"";

        for(Catalog catalog: j1007){
            List<Order> orders=OrderDao.findOrder(null, catalog.getCatalog_id(),null,null );
            for(Order order:orders){
                if(order.getDate().compareTo(date1) > 0){
                    j7++;
                }
            }
        }
        String j007=j7+"";
        
        for(Catalog catalog: j1008){
            List<Order> orders=OrderDao.findOrder(null, catalog.getCatalog_id(),null,null );
            for(Order order:orders){
                if(order.getDate().compareTo(date1) > 0){
                    j8++;
                }
            }
        }
        String j008=j8+"";
        
        for(Catalog catalog: j1009){
            List<Order> orders=OrderDao.findOrder(null, catalog.getCatalog_id(),null,null );
            for(Order order:orders){
                if(order.getDate().compareTo(date1) > 0){
                    j9++;
                }
            }
        }
        String j009=j9+"";

        for(Catalog catalog: j1010){
            List<Order> orders=OrderDao.findOrder(null, catalog.getCatalog_id(),null,null );
            for(Order order:orders){
                if(order.getDate().compareTo(date1) > 0){
                    j10++;
                }
            }
        }
        String j010=j10+"";

        for(Catalog catalog: j1011){
            List<Order> orders=OrderDao.findOrder(null, catalog.getCatalog_id(),null,null );
            for(Order order:orders){
                if(order.getDate().compareTo(date1) > 0){
                    j11++;
                }
            }
        }
        String j011=j11+"";

        for(Catalog catalog: j1012){
            List<Order> orders=OrderDao.findOrder(null, catalog.getCatalog_id(),null,null );
            for(Order order:orders){
                if(order.getDate().compareTo(date1) > 0){
                    j12++;
                }
            }
        }
        String j012=j12+"";

        for(Catalog catalog: j1013){
            List<Order> orders=OrderDao.findOrder(null, catalog.getCatalog_id(),null,null );
            for(Order order:orders){
                if(order.getDate().compareTo(date1) > 0){
                    j13++;
                }
            }
        }
        String j013=j13+"";

        for(Catalog catalog: j1014){
            List<Order> orders=OrderDao.findOrder(null, catalog.getCatalog_id(),null,null );
            for(Order order:orders){
                if(order.getDate().compareTo(date1) > 0){
                    j14++;
                }
            }
        }
        String j014=j14+"";
        
        for(Catalog catalog: j1015){
            List<Order> orders=OrderDao.findOrder(null, catalog.getCatalog_id(),null,null );
            for(Order order:orders){
                if(order.getDate().compareTo(date1) > 0){
                    j15++;
                }
            }
        }
        String j015=j15+"";

        for(Catalog catalog: j1016){
            List<Order> orders=OrderDao.findOrder(null, catalog.getCatalog_id(),null,null );
            for(Order order:orders){
                if(order.getDate().compareTo(date1) > 0){
                    j16++;
                }
            }
        }
        String j016=j16+"";
        
        for(Catalog catalog: j1017){
            List<Order> orders=OrderDao.findOrder(null, catalog.getCatalog_id(),null,null );
            for(Order order:orders){
                if(order.getDate().compareTo(date1) > 0){
                    j17++;
                }
            }
        }
        String j017=j17+"";

        jsum=j1+ j2+ j3+ j4+ j5+ j6+ j7+ j8+ j9+ j10+ j11+ j12+ j13+ j14+ j15+ j16+ j17;
        
        int jarr[] = {j1, j2, j3, j4, j5, j6, j7, j8, j9, j10, j11, j12, j13, j14, j15, j16, j17};
        String jjarr[]={"j1001", "j1002", "j1003", "j1004", "j1005", "j1006", "j1007", "j1008", "j1009", "j1010", "j1011", "j1012", "j1013", "j1014", "j1015", "j1016", "j1017"};

        for (int i = 0; i < jarr.length; i++) {
            for (int j = 0; j < jarr.length - i - 1; j++) {
                if (jarr[j] < jarr[j + 1]) {
                    int jemp = jarr[j + 1];
                    jarr[j + 1] = jarr[j];
                    jarr[j] = jemp;
                    String jjemp=jjarr[j+1];
                    jjarr[j + 1] = jjarr[j];
                    jjarr[j] = jjemp;
                }
            }
        }

        String jout=jjarr[0]+", "+jjarr[1]+", "+jjarr[3]+", "+jjarr[4]+", "+jjarr[5]+", "+jjarr[6]+", "+jjarr[7]+", "+jjarr[8]+", "+jjarr[9];
        System.out.println(jout);
        label3.setText(jout);

        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                        new PieChart.Data("j1001", j1),
                        new PieChart.Data("j1002", j2),
                        new PieChart.Data("j1003", j3),
                        new PieChart.Data("j1004", j4),
                        new PieChart.Data("j1005", j5),
                        new PieChart.Data("j1006", j6),
                        new PieChart.Data("j1007", j7),
                        new PieChart.Data("j1008", j8),
                        new PieChart.Data("j1009", j9),
                        new PieChart.Data("j1010", j10),
                        new PieChart.Data("j1011", j11),
                        new PieChart.Data("j1012", j12),
                        new PieChart.Data("j1013", j13),
                        new PieChart.Data("j1014", j14),
                        new PieChart.Data("j1015", j15),
                        new PieChart.Data("j1016", j16),
                        new PieChart.Data("j1017", j17));
        pieChart.setData(pieChartData);
    }

    /**
     * Click check compara.
     *
     * @param actionEvent the action event
     * @throws Exception the exception
     */
    @FXML
    protected void click_check_compara(MouseEvent actionEvent) throws Exception{
        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                        new PieChart.Data("shirt", ssum),
                        new PieChart.Data("trouser", tsum),
                        new PieChart.Data("jacket", jsum));
        pieChart.setData(pieChartData);
    }

    /**
     * Initialize.
     *
     * @param location  the location
     * @param resources the resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        ui_top10.setStyle(Tools.defaultStyle);

    }


}
