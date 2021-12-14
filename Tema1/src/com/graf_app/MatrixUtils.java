package com.graf_app;

import java.util.List;

public class MatrixUtils {

    private static String m_filePath;

    public static void setFilePath(String filePath){

        m_filePath = filePath;
    }

    public static void ConstructMatrix(List<Node> nodeList , List<Arc> arcList, boolean isOriented )
    {
        if(isOriented){
            grafOrientatMatrix(nodeList , arcList);
        }
        else{
            grafNeorientatMatrix(nodeList , arcList);
        }
    };

    public static void grafOrientatMatrix(List<Node> nodeList , List<Arc> arcList ){

    }
    public static void grafNeorientatMatrix(List<Node> nodeList , List<Arc> arcList ){

    }
}
