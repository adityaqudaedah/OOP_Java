package com.oop;

class Player{
    //Data member
    String name;
    private double health;
    private double armor;
    Weapon weapon;
    //constructor
    Player(String name){
        this.name = name;
        this.setHealth(100);
        this.setArmor(30);
    }
    void shoot(Player annotherPlayer,Weapon weaponName) {
        double annotherPlayerArmor= annotherPlayer.getArmor();
        double annotherPlayerHealth = annotherPlayer.getHealth();
        annotherPlayerArmor-= weaponName.getDamage();
        if (annotherPlayerArmor < 0){
            annotherPlayerHealth+=annotherPlayerArmor;
            System.out.println("Bam ! "+ annotherPlayer.name+" hit by "+weaponName.name);
            if (annotherPlayerHealth>0){
                System.out.println(annotherPlayer.name +" hp now, " + annotherPlayerHealth);
            }else{
                System.out.println("You killed "+ annotherPlayer.name+" !" );
                System.out.println("Mission Success !");
            }
        }
    }
    void equipWeapon(Weapon weapon){
        this.weapon = weapon;
    }
    void display(){
        System.out.println("Player Name : "+this.name+"\nHealth : "+this.health+" Hp"+"\nArmor : "+this.armor);
        this.weapon.display();
    }
    //getter and setter for health
    public double getHealth(){
        return this.health;
    }
    public void setHealth(double health){
        this.health = health;
    }
    //getter and setter for armor
    public double getArmor(){
        return this.armor;
    }
    public void setArmor(double armor){
        this.armor = armor;

    }
}

class Weapon{
    //Data member
    String name;
    private double damage;
    //constructor
    Weapon(String name){
        this.name = name;
    }
    void display(){
        System.out.println("Weapon : "+this.name+"\nDamage : "+this.damage);
    }

    //getter and setter for weapon
    public double getDamage(){
        return this.damage;
    }
    public void setDamage(double damage){
        this.damage = damage;
    }
}
//Main class
public class Main {
    public static void main(String[] args) {
        //player1 info
        System.out.println();
        System.out.println("-Player Info-");
        Player player1 = new Player("Agoy");
        Weapon assault = new Weapon("AK-47" );
        assault.setDamage(35.5);
        player1.equipWeapon(assault);
        player1.display();
        //player2 info
        System.out.println("\n-Player Info-");
        Player player2 = new Player("Jamet");
        Weapon launcher = new Weapon("Bazoka" );
        launcher.setDamage(150);
        player2.equipWeapon(launcher);
        player2.display();
        //The Battle Field
        System.out.println("\nThe Battle Field !!!");
        System.out.println("Scene -1");
        player1.shoot(player2,assault);
        System.out.println("Scene -2");
        player2.shoot(player1,launcher);

    }
}