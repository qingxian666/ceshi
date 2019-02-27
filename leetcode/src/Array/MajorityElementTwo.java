package Array;

import java.util.ArrayList;
import java.util.List;

public class MajorityElementTwo {
	/*
    ˼·��Ħ��ͶƱ�����棬����n/3�������ֻ����������
    ��ѡ��������ѡ��A,B,�������飬���ͶA������A������A��Ʊ��++;���ͶB��B��Ʊ��++��
    ���A,B����Ͷ������A��B������ȣ�,��ô����ʱ�Ƿ�AB�к�ѡ�˵�Ʊ���Ƿ�Ϊ0�����Ϊ0,���Ϊ�µĺ�ѡ�ˣ�
    ���A,B�����˵�Ʊ������Ϊ0����ôA,B������ѡ�˵�Ʊ����--��
    ����������ѡ��������ѡ�ˣ�������������ѡ���Ƿ�����>n/3������Ҫ�ٱ���һ�����飬�ҳ�������ѡ�˵ľ���Ʊ��
     */
    public List<Integer> majorityElement(int[] nums) {
        if (nums==null||nums.length==0){
            return new ArrayList<Integer>();
        }

        //��ʼ��������������ѡ���Լ���Ӧ��Ʊ��
        int candidateA=nums[0];
        int candidateB=nums[0];
        int countA=0;
        int countB=0;

        // ��������
        for (int num:nums){
            if (num==candidateA){ //ͶA
                countA++;
                continue;
            }

            if (num==candidateB){// ͶB
                countB++;
                continue;
            }
            //��ʱA,B����Ͷ,����Ƿ���Ʊ��Ϊ0��������Ϊ0������º�ѡ��
            if (countA==0){
                candidateA=num;
                countA++;
                continue;
            }

            if (countB==0){
                candidateB=num;
                countB++;
                continue;
            }

            //��ʱ������ѡ�˵�Ʊ��������1���ҵ�ǰѡ����ͶAB����ôA,B��Ӧ��Ʊ����Ҫ--;
            countA--;
            countB--;
        }

        // ��һ�ֱ����ҳ���������ѡ�ˣ�������������ѡ���Ƿ������Ʊ������N/3��Ȼû��ȷ������Ҫ���±�����ȷ��Ʊ��
        countA=0;
        countB=0;

        for (int num:nums){
            if (num==candidateA){
                countA++;
            }else if (num==candidateB){
                countB++;
            }
        }

        List<Integer> resultList=new ArrayList<>();

        if (countA>nums.length/3){
            resultList.add(candidateA);
        }

        if (countB>nums.length/3){
            resultList.add(candidateB);
        }

        return resultList;
    }
}
