package com.saifiahmada.belajarzk.viewmodel;

import java.util.ArrayList;
import java.util.List;

import com.saifiahmada.belajarzk.base.TrioBasePageVM;

/** @author Saifi Ahmada Feb 13, 2013 9:56:48 AM  **/

public class TestMenuVM extends TrioBasePageVM {
	
	String message;
    List<Node> nodes;
   
    public TestMenuVM(){
            nodes = new ArrayList<Node>();
            nodes.add(createNode("Master",1,1));
            nodes.add(createNode("Transaksi",1,1));
            nodes.add(createNode("Design",2,1));
            nodes.add(createNode("Laporan",3,2));
            nodes.add(createNode("Utility",3,2));
    }
   
    public List<Node> getNodes(){
            return nodes;
    }
   
    Node createNode(String name,int children,int nested){
            Node n = new Node(name);
            if(nested>0){
                    for(int i=0;i<children;i++){
                            n.addChild(createNode(name+"_"+i,i==children-1?0:children,nested-1));
                    }
            }
            return n;
    }


//  public String getMessage() {
//          return message;
//  }

//  @Command @NotifyChange("message")
//  public void menuClicked(@BindingParam("node") Node node ){
//          message = "clicked "+node.getName();
//  }
   
    static public class Node{
            List<Node> children;
            String name;
           
            public Node(String name){
                    this.name = name;
                    children = new ArrayList<Node>();
            }
           
            public void addChild(Node node){
                    children.add(node);
            }
           
            public List<Node> getChildren(){
                    return children;
            }
           
            public String getName(){
                    return name;
            }
           
    }
}
