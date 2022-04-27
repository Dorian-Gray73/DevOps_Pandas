package com.devops;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class DataFrameTest {

    public <E> ArrayList<E> createArrayList(Integer[] tab){
        ArrayList<E> list = new ArrayList<E>();
        for (Integer i : tab) {
            list.add((E) i);
        }
        return list;
    }

    public <E> ArrayList<E> createArrayList(String[] tab){
        ArrayList<E> list = new ArrayList<E>();
        for (String i : tab) {
            list.add((E) i);
        }
        return list;
    }
    
    @Test
    public void CreateDataFrameFromData(){
        try {
            ArrayList<String> labels = new ArrayList<String>();
            labels.add("col1");
            labels.add("col2");
            labels.add("col3");
            ArrayList<ArrayList<?>> data = new ArrayList<ArrayList<?>>();
            ArrayList<Integer> colonne1 = new ArrayList<Integer>();
            colonne1.add(1);
            colonne1.add(2);
            colonne1.add(3);
            data.add(colonne1);
            ArrayList<String> colonne2 = new ArrayList<String>();
            colonne2.add("4");
            colonne2.add("5");
            colonne2.add("6");
            data.add(colonne2);
            ArrayList<Integer> colonne3 = new ArrayList<Integer>();
            colonne3.add(7);
            colonne3.add(8);
            colonne3.add(9);
            data.add(colonne3);
            DataFrame df = new DataFrame(labels, data);
            assertEquals("Obtenir le nombre de ligne",3, df.nbLigne());
            assertEquals("Obtenir le nombre de colonne",3 , df.nbColonne());
            assertEquals("Obtenir la premier colonne", colonne1, df.getColumn("col1"));
            assertEquals("Obtenir la deuxieme colonne", colonne2, df.getColumn("col2"));
            assertEquals("Obtenir la troisieme colonne", colonne3, df.getColumn("col3"));
            System.out.println(df.getColumn("col1").get(0).getClass());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
/*
    @Test
    public void CreateDataFrameFromCSV(){
        try {
            DataFrame df = new DataFrame("src/test/resources/dataframe.csv");
            assertEquals("Obtenir le nombre de ligne",3, df.nbLigne());
            assertEquals("Obtenir le nombre de colonne",3 , df.nbColonne());
            assertEquals("Obtenir la premier colonne", "1", df.getColumn("col1").get(0));
            assertEquals("Obtenir la deuxieme colonne", "2", df.getColumn("col1").get(1));
            assertEquals("Obtenir la troisieme colonne", "3", df.getColumn("col1").get(2));
            assertEquals("Obtenir la premier colonne", "4", df.getColumn("col2").get(0));
            assertEquals("Obtenir la deuxieme colonne", "5", df.getColumn("col2").get(1));
            assertEquals("Obtenir la troisieme colonne", "6", df.getColumn("col2").get(2));
            assertEquals("Obtenir la premier colonne", "7", df.getColumn("col3").get(0));
            assertEquals("Obtenir la deuxieme colonne", "8", df.getColumn("col3").get(1));
            assertEquals("Obtenir la troisieme colonne", "9", df.getColumn("col3").get(2));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//*/

    @Test
    public void TestnbLigne(){
        ArrayList<String> labels = new ArrayList<String>();
            labels.add("col1");
            ArrayList<ArrayList<?>> data = new ArrayList<ArrayList<?>>();
            ArrayList<Integer> colonne1 = new ArrayList<Integer>();
            colonne1.add(1);
            colonne1.add(2);
            colonne1.add(3);
            data.add(colonne1);
        DataFrame df;
        try {
            df = new DataFrame(labels, data);
            assertEquals("Nombre de ligne : ",3, df.nbLigne());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void TestnbLigneError(){
        ArrayList<String> labels = new ArrayList<String>();
            labels.add("col1");
            labels.add("col2");
            labels.add("col3");
            ArrayList<ArrayList<?>> data = new ArrayList<ArrayList<?>>(3);
            ArrayList<Integer> colonne1 = new ArrayList<Integer>();
            data.add(colonne1);
            ArrayList<Integer> colonne2 = new ArrayList<Integer>();
            data.add(colonne2);
            ArrayList<Integer> colonne3 = new ArrayList<Integer>();
            data.add(colonne3);
        DataFrame df;
        try {
            df = new DataFrame(labels, data);
            assertEquals("Nombre de ligne ", 0, df.nbLigne());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void TestnbColonne(){
        ArrayList<String> labels = new ArrayList<String>();
            labels.add("col1");
            ArrayList<ArrayList<?>> data = new ArrayList<ArrayList<?>>();
            ArrayList<Integer> colonne1 = new ArrayList<Integer>();
            colonne1.add(1);
            colonne1.add(2);
            colonne1.add(3);
            data.add(colonne1);
        DataFrame df;
        try {
            df = new DataFrame(labels, data);
            assertEquals("Nombre de colonne : ", 1, df.nbColonne());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void TestnbColonneError(){
        ArrayList<String> labels = new ArrayList<String>();
            ArrayList<ArrayList<?>> data = new ArrayList<ArrayList<?>>();
        DataFrame df;
        try {
            df = new DataFrame(labels, data);
            assertEquals("Nombre de colonne ", 0, df.nbColonne());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void TestGetColumn(){
        ArrayList<String> labels = new ArrayList<String>();
            labels.add("col1");
            labels.add("col2");
            labels.add("col3");
            ArrayList<ArrayList<?>> data = new ArrayList<ArrayList<?>>();
            ArrayList<Integer> colonne1 = new ArrayList<Integer>();
            colonne1.add(1);
            colonne1.add(2);
            colonne1.add(3);
            data.add(colonne1);
            ArrayList<Integer> colonne2 = new ArrayList<Integer>();
            colonne2.add(4);
            colonne2.add(5);
            colonne2.add(6);
            data.add(colonne2);
            ArrayList<Integer> colonne3 = new ArrayList<Integer>();
            colonne3.add(7);
            colonne3.add(8);
            colonne3.add(9);
            data.add(colonne3);
        DataFrame df;
        try {
            df = new DataFrame(labels, data);
            assertEquals("Nombre de colonne : ",3, df.nbColonne());
            assertEquals("Obtenir la premiere colonne", colonne1, df.getColumn("col1"));
            assertEquals("Obtenir la deuxieme colonne", colonne2, df.getColumn("col2"));
            assertEquals("Obtenir la troisieme colonne", colonne3, df.getColumn("col3"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //TODO : Test getColumnError
    /*
    @Test (expected = IllegalArgumentException.class)
    public void TestGetColumnError() {
        ArrayList<String> labels = new ArrayList<String>();
            labels.add("col1");
            labels.add("col2");
            labels.add("col3");
            ArrayList<ArrayList<?>> data = new ArrayList<ArrayList<?>>();
            ArrayList<Integer> colonne1 = new ArrayList<Integer>();
            colonne1.add(1);
            colonne1.add(2);
            colonne1.add(3);
            data.add(colonne1);
        DataFrame df;
        try {
            df = new DataFrame(labels, data);
            df.getColumn("col4");
        } catch (IllegalArgumentException e) {
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    */
 
    @Test
    public void TestHead_int(){
        ArrayList<String> labels = new ArrayList<String>();
            labels.add("col1");
            labels.add("col2");
            labels.add("col3");
            ArrayList<ArrayList<?>> data = new ArrayList<ArrayList<?>>();
            ArrayList<Integer> colonne1 = new ArrayList<Integer>();
            colonne1.add(1);
            colonne1.add(2);
            colonne1.add(3);
            data.add(colonne1);
            ArrayList<Integer> colonne2 = new ArrayList<Integer>();
            colonne2.add(4);
            colonne2.add(5);
            colonne2.add(6);
            data.add(colonne2);
            ArrayList<Integer> colonne3 = new ArrayList<Integer>();
            colonne3.add(7);
            colonne3.add(8);
            colonne3.add(9);
            data.add(colonne3);
        DataFrame df;
        try {
            df = new DataFrame(labels, data);
            assertEquals("Nombre de colonne : ",3, df.nbColonne());
            assertEquals("Obtenir la premiere colonne","col1\tcol2\tcol3\t\n1\t4\t7\t\n", df.head(1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

     @Test
    public void TestHead(){
        ArrayList<String> labels = new ArrayList<String>();
            labels.add("col1");
            labels.add("col2");
            labels.add("col3");
            ArrayList<ArrayList<?>> data = new ArrayList<ArrayList<?>>();
            ArrayList<Integer> colonne1 = new ArrayList<Integer>();
            colonne1.add(1);
            colonne1.add(2);
            colonne1.add(3);
            data.add(colonne1);
            ArrayList<Integer> colonne2 = new ArrayList<Integer>();
            colonne2.add(4);
            colonne2.add(5);
            colonne2.add(6);
            data.add(colonne2);
            ArrayList<Integer> colonne3 = new ArrayList<Integer>();
            colonne3.add(7);
            colonne3.add(8);
            colonne3.add(9);
            data.add(colonne3);
        DataFrame df;
        try {
            df = new DataFrame(labels, data);
            assertEquals("Nombre de colonne : ",3, df.nbColonne());
            assertEquals("Obtenir la premiere colonne","col1\tcol2\tcol3\t\n1\t4\t7\t\n2\t5\t8\t\n3\t6\t9\t\n", df.head());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void TestToString(){
        ArrayList<String> labels = new ArrayList<String>();
            labels.add("col1");
            labels.add("col2");
            ArrayList<ArrayList<?>> data = new ArrayList<ArrayList<?>>();
            ArrayList<Integer> colonne1 = new ArrayList<Integer>();
            colonne1.add(1);
            colonne1.add(2);
            colonne1.add(3);
            data.add(colonne1);
            ArrayList<Integer> colonne2 = new ArrayList<Integer>();
            colonne2.add(4);
            colonne2.add(5);
            colonne2.add(6);
            data.add(colonne2);
        DataFrame df;
        try {
            df = new DataFrame(labels, data);
            assertEquals("Nombre de colonne : ",2, df.nbColonne());
            assertEquals("Obtenir la premiere colonne","col1\tcol2\t\n1\t4\t\n2\t5\t\n3\t6\t\n", df.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void TestMoyenne(){
            ArrayList<String> labels = new ArrayList<String>();
            labels.add("col1");
            labels.add("col2");
            ArrayList<ArrayList<?>> data = new ArrayList<ArrayList<?>>();
            ArrayList<Integer> colonne1 = new ArrayList<Integer>();
            colonne1.add(1);
            colonne1.add(2);
            colonne1.add(3);
            data.add(colonne1);
            ArrayList<Integer> colonne2 = new ArrayList<Integer>();
            colonne2.add(4);
            colonne2.add(5);
            colonne2.add(6);
            data.add(colonne2);
        DataFrame df;
        try {
            df = new DataFrame(labels, data);
            assertEquals("Nombre de colonne : ", 2, df.nbColonne());
            System.out.println(df.moyenne("col1"));
            double res = 2.0;
            assertEquals("Moyenne : ",res, df.moyenne("col1"),0.001);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void TestLabelSelection(){
        String[] nomLabels = {"col1", "col2", "col3"};
        ArrayList<String> labels = createArrayList(nomLabels);
        ArrayList<ArrayList<?>> data = new ArrayList<ArrayList<?>>();
        Integer[] col1 = {1, 2, 3};
        ArrayList<Integer> colonne1 = createArrayList(col1);
        Integer[] col2 = {4, 5, 6};
        ArrayList<Integer> colonne2 = createArrayList(col2);
        Integer[] col3 = {7, 8, 9};
        ArrayList<Integer> colonne3 = createArrayList(col3);
        data.add(colonne1);
        data.add(colonne2);
        data.add(colonne3);
        DataFrame df, df2;
        try {
            df = new DataFrame(labels, data);
            df2 = df.labelSelection("col2");
            assertEquals("Nombre de colonne : ",1, df2.nbColonne());
            assertEquals("Obtenir le DataFrame","col2\t\n4\t\n5\t\n6\t\n", df2.toString());
        } catch (Exception e) {
            e.printStackTrace();
            fail("Problème dans le test.");
        }
    }

    @Test
    public void TestMax(){
            ArrayList<String> labels = new ArrayList<String>();
            labels.add("col1");
            labels.add("col2");
            ArrayList<ArrayList<?>> data = new ArrayList<ArrayList<?>>();
            ArrayList<Integer> colonne1 = new ArrayList<Integer>();
            colonne1.add(1);
            colonne1.add(2);
            colonne1.add(3);
            data.add(colonne1);
            ArrayList<Integer> colonne2 = new ArrayList<Integer>();
            colonne2.add(4);
            colonne2.add(5);
            colonne2.add(6);
            data.add(colonne2);
        DataFrame df;
        try {
            df = new DataFrame(labels, data);
            assertEquals("Nombre de colonne : ", 2, df.nbColonne());
            assertEquals("Max : ",6.0, df.max("col2"),0.001);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //test min
    @Test
    public void TestMin(){
            ArrayList<String> labels = new ArrayList<String>();
            labels.add("col1");
            labels.add("col2");
            ArrayList<ArrayList<?>> data = new ArrayList<ArrayList<?>>();
            ArrayList<Integer> colonne1 = new ArrayList<Integer>();
            colonne1.add(1);
            colonne1.add(2);
            colonne1.add(3);
            data.add(colonne1);
            ArrayList<Integer> colonne2 = new ArrayList<Integer>();
            colonne2.add(4);
            colonne2.add(5);
            colonne2.add(6);
            data.add(colonne2);
        DataFrame df;
        try {
            df = new DataFrame(labels, data);
            assertEquals("Nombre de colonne : ", 2, df.nbColonne());
            assertEquals("Min : ",1.0, df.min("col1"),0.001);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void TestLabelsSelection(){
        String[] nomLabels = {"col1", "col2", "col3"};
        ArrayList<String> labels = createArrayList(nomLabels);
        ArrayList<ArrayList<?>> data = new ArrayList<ArrayList<?>>();
        Integer[] col1 = {1, 2, 3};
        ArrayList<Integer> colonne1 = createArrayList(col1);
        Integer[] col2 = {4, 5, 6};
        ArrayList<Integer> colonne2 = createArrayList(col2);
        Integer[] col3 = {7, 8, 9};
        ArrayList<Integer> colonne3 = createArrayList(col3);
        data.add(colonne1);
        data.add(colonne2);
        data.add(colonne3);
        DataFrame df, df2;
        try {
            df = new DataFrame(labels, data);
            nomLabels = new String[]{"col2", "col3"};
            df2 = df.labelSelection(nomLabels);
            assertEquals("Nombre de colonne : ", 2, df2.nbColonne());
            assertEquals("Obtenir le DataFrame","col2\tcol3\t\n4\t7\t\n5\t8\t\n6\t9\t\n", df2.toString());
        } catch (Exception e) {
            e.printStackTrace();
            fail("Problème dans le test.");
        }
    }

    @Test
    public void TestMediane(){
            ArrayList<String> labels = new ArrayList<String>();
            labels.add("col1");
            ArrayList<ArrayList<?>> data = new ArrayList<ArrayList<?>>();
            ArrayList<Float> colonne1 = new ArrayList<Float>();
            colonne1.add(1.0f);
            colonne1.add(2.0f);
            colonne1.add(3.0f);
            colonne1.add(4.0f);
            data.add(colonne1);
            DataFrame df;
        try {
            df = new DataFrame(labels, data);
            assertEquals("Nombre de colonne : ", 1, df.nbColonne());
            assertEquals("Mediane : ", 2.5, df.mediane("col1"),0.001);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //test premier quartile
    @Test
    public void TestPremierQuartile(){
            ArrayList<String> labels = new ArrayList<String>();
            labels.add("col1");
            ArrayList<ArrayList<?>> data = new ArrayList<ArrayList<?>>();
            ArrayList<Float> colonne1 = new ArrayList<Float>();
            colonne1.add(1.0f);
            colonne1.add(2.0f);
            colonne1.add(3.0f);
            colonne1.add(4.0f);
            data.add(colonne1);
            DataFrame df;
        try {
            df = new DataFrame(labels, data);
            assertEquals("Nombre de colonne : ", 1, df.nbColonne());
            assertEquals("Premier quartile : ", 1.5, df.premierQuartile("col1"),0.001);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void TestTroisiemeQuartile(){
            ArrayList<String> labels = new ArrayList<String>();
            labels.add("col1");
            ArrayList<ArrayList<?>> data = new ArrayList<ArrayList<?>>();
            ArrayList<Integer> colonne1 = new ArrayList<Integer>();
            colonne1.add(1);
            colonne1.add(2);
            colonne1.add(3);
            colonne1.add(4);
            data.add(colonne1);
            DataFrame df;
        try {
            df = new DataFrame(labels, data);
            assertEquals("Nombre de colonne : ", 1, df.nbColonne());
            assertEquals("Troisieme quartile : ", 3.5, df.troisiemeQuartile("col1"),0.001);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //test interquartile range
    @Test
    public void distanceInterQuartile(){
            ArrayList<String> labels = new ArrayList<String>();
            labels.add("col1");
            ArrayList<ArrayList<?>> data = new ArrayList<ArrayList<?>>();
            ArrayList<Integer> colonne1 = new ArrayList<Integer>();
            colonne1.add(1);
            colonne1.add(2);
            colonne1.add(3);
            colonne1.add(4);
            data.add(colonne1);
            DataFrame df;
        try {
            df = new DataFrame(labels, data);
            assertEquals("Nombre de colonne : ", 1, df.nbColonne());
            assertEquals("Interquartile range : ",2.0, df.distanceInterQuartile("col1"),0.001);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void TestLabelsSelectionCopy(){
        String[] nomLabels = {"col1", "col2", "col3"};
        ArrayList<String> labels = createArrayList(nomLabels);
        ArrayList<ArrayList<?>> data = new ArrayList<ArrayList<?>>();
        Integer[] col1 = {1, 2, 3};
        ArrayList<Integer> colonne1 = createArrayList(col1);
        Integer[] col2 = {4, 5, 6};
        ArrayList<Integer> colonne2 = createArrayList(col2);
        Integer[] col3 = {7, 8, 9};
        ArrayList<Integer> colonne3 = createArrayList(col3);
        data.add(colonne1);
        data.add(colonne2);
        data.add(colonne3);
        DataFrame df, df2;
        try {
            df = new DataFrame(labels, data);
            nomLabels = new String[]{"col1", "col2", "col3"};
            df2 = df.labelSelection(nomLabels);
            assertEquals("Nombre de colonne : ", 3, df2.nbColonne());
            assertEquals("Obtenir le DataFrame","col1\tcol2\tcol3\t\n1\t4\t7\t\n2\t5\t8\t\n3\t6\t9\t\n", df2.toString());
        } catch (Exception e) {
            e.printStackTrace();
            fail("Problème dans le test.");
        }
    }

    @Test
    public void TestIndexSelection(){
        String[] nomLabels = {"col1", "col2", "col3"};
        ArrayList<String> labels = createArrayList(nomLabels);
        ArrayList<ArrayList<?>> data = new ArrayList<ArrayList<?>>();
        Integer[] col1 = {1, 2, 3};
        ArrayList<Integer> colonne1 = createArrayList(col1);
        Integer[] col2 = {4, 5, 6};
        ArrayList<Integer> colonne2 = createArrayList(col2);
        Integer[] col3 = {7, 8, 9};
        ArrayList<Integer> colonne3 = createArrayList(col3);
        data.add(colonne1);
        data.add(colonne2);
        data.add(colonne3);
        DataFrame df, df2;
        try {
            df = new DataFrame(labels, data);
            df2 = df.ligneIndexSelection(1);
            assertEquals("Nombre de colonne : ", 3, df2.nbColonne());
            assertEquals("Obtenir le DataFrame","col1\tcol2\tcol3\t\n1\t4\t7\t\n", df2.toString());
        } catch (Exception e) {
            e.printStackTrace();
            fail("Problème dans le test.");
        }
    }

    @Test
    public void TestIndexsSelection(){
        String[] nomLabels = {"col1", "col2", "col3"};
        ArrayList<String> labels = createArrayList(nomLabels);
        ArrayList<ArrayList<?>> data = new ArrayList<ArrayList<?>>();
        Integer[] col1 = {1, 2, 3};
        ArrayList<Integer> colonne1 = createArrayList(col1);
        Integer[] col2 = {4, 5, 6};
        ArrayList<Integer> colonne2 = createArrayList(col2);
        Integer[] col3 = {7, 8, 9};
        ArrayList<Integer> colonne3 = createArrayList(col3);
        data.add(colonne1);
        data.add(colonne2);
        data.add(colonne3);
        DataFrame df, df2;
        try {
            df = new DataFrame(labels, data);
            Integer[] indexs = {1, 3};
            df2 = df.ligneIndexSelection(indexs);
            assertEquals("Nombre de colonne : ", 3, df2.nbColonne());
            assertEquals("Obtenir le DataFrame","col1\tcol2\tcol3\t\n1\t4\t7\t\n3\t6\t9\t\n", df2.toString());
        } catch (Exception e) {
            e.printStackTrace();
            fail("Problème dans le test.");
        }
    }



}
