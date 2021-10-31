package one;

import com.sun.jdi.PathSearchingVirtualMachine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author shkstart
 * @create 2021-10-28 14:44
 */
public class ParkingSystem implements IParking,IParams {
    int big;
    int medium;
    int small;
    boolean output;

    public ParkingSystem(int big, int medium, int small) {
        this.big = big;
        this.medium = medium;
        this.small = small;
    }

    //获取大车位
    public int getBig() {
        return big;
    }

    @Override
    //获取中车位
    public int getMedium() {
        return medium;
    }

    @Override
    //获取小车位
    public int getSmall() {
        return small;
    }

    @Override
    // 获取停车序列，例如 [1 2 2 3] 表示 依次停一辆大车，中车，中车，小车
    public ArrayList<Integer> getPlanParking() throws Exception {
        Scanner sc1 = new Scanner(System.in);
        System.out.println("请输入获取需要的停车总个数:");
        int n = sc1.nextInt();
        System.out.println("请输入获取需要的停车类别，每输入一个就按回车行:");
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int j = 0; j < n; j++) {
            list.add(in.nextInt());
        }
        //  List<Integer> list =Arrays.asList(num);
        return list;
    }

    public void print() {
    }

    @Override
    //判有没有车位
    public boolean addCar(int carType) {
        if (carType == 1) {
            if (big >= carType) {
                big--;

                return true;
            } else {
                return false;
            }
        } else if (carType == 2) {
            int car_medium = carType - 1;
            if (medium >= car_medium) {
                medium--;
                return true;

            } else {
                return false;
            }
        } else if (carType == 3) {
            int car_samll = carType - 2;
            if (small >= car_samll) {
                small--;
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }


    // 获取输入文本
    public static String parse() {
        boolean input = true;
        String[] words = null;
        while (input) {
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入相应文本:");
            String i = sc.next();
            words = i.split(",");
            //返回输入文本
            String word = Arrays.toString(words);
            if (!word.substring(2, 15).equals("ParkingSystem")) {
                System.out.println("这不是标准格式,请重新输入：");
                continue;
            }
            break;
        }
        return Arrays.toString(words);
    }

    public static void main(String[] args) throws Exception {
        ParkingSystem p=new ParkingSystem(1,1,0);
        p.parse();
        ArrayList<Integer> plan = p.getPlanParking();
        ArrayList<Boolean> a=new ArrayList<Boolean>();
        for(int i=0;i<plan.size();i++){
            a.add(p.addCar(plan.get(i)));
        }
        System.out.println(a);

    }
}






