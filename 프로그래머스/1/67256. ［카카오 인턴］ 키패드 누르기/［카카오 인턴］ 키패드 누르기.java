import java.util.*;

class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();

        int[] leftHand = {3, 0};
        int[] rightHand = {3, 2};

        for(int i=0; i<numbers.length; i++) {
            int cur = numbers[i];

            if(cur == 1) {
                sb.append('L');
                leftHand[0] = 0;
                leftHand[1] = 0;
            } else if(cur == 4) {
                sb.append('L');
                leftHand[0] = 1;
                leftHand[1] = 0;
            } else if(cur == 7) {
                sb.append('L');
                leftHand[0] = 2;
                leftHand[1] = 0;
            } else if(cur == 3) {
                sb.append('R');
                rightHand[0] = 0;
                rightHand[1] = 2;
            } else if(cur == 6) {
                sb.append('R');
                rightHand[0] = 1;
                rightHand[1] = 2;
            } else if(cur == 9) {
                sb.append('R');
                rightHand[0] = 2;
                rightHand[1] = 2;
            } else if(cur == 2) {
                int leftRow = Math.abs(leftHand[0] - 0);
                int leftCol = Math.abs(leftHand[1] - 1);
                int left = leftRow + leftCol;
                int rightRow = Math.abs(rightHand[0] - 0);
                int rightCol = Math.abs(rightHand[1] - 1);
                int right = rightRow + rightCol;
                if (left > right) {
                    sb.append("R");
                    rightHand[0] = 0;
                    rightHand[1] = 1;
                } else if (right > left) {
                    sb.append("L");
                    leftHand[0] = 0;
                    leftHand[1] = 1;
                } else if (right == left) {
                    if(hand.equals("right")) {
                        sb.append("R");
                        rightHand[0] = 0;
                        rightHand[1] = 1;
                    } else {
                        sb.append("L");
                        leftHand[0] = 0;
                        leftHand[1] = 1;
                    }
                }
            } else if(cur == 5) {
                int leftRow = Math.abs(leftHand[0] - 1);
                int leftCol = Math.abs(leftHand[1] - 1);
                int left = leftRow + leftCol;
                int rightRow = Math.abs(rightHand[0] - 1);
                int rightCol = Math.abs(rightHand[1] - 1);
                int right = rightRow + rightCol;
                if (left > right) {
                    sb.append("R");
                    rightHand[0] = 1;
                    rightHand[1] = 1;
                } else if (right > left) {
                    sb.append("L");
                    leftHand[0] = 1;
                    leftHand[1] = 1;
                } else if (right == left) {
                    if(hand.equals("right")) {
                        sb.append("R");
                        rightHand[0] = 1;
                        rightHand[1] = 1;
                    } else {
                        sb.append("L");
                        leftHand[0] = 1;
                        leftHand[1] = 1;
                    }
                }
            } else if(cur == 8) {
                int leftRow = Math.abs(leftHand[0] - 2);
                int leftCol = Math.abs(leftHand[1] - 1);
                int left = leftRow + leftCol;
                int rightRow = Math.abs(rightHand[0] - 2);
                int rightCol = Math.abs(rightHand[1] - 1);
                int right = rightRow + rightCol;
                if (left > right) {
                    sb.append("R");
                    rightHand[0] = 2;
                    rightHand[1] = 1;
                } else if (right > left) {
                    sb.append("L");
                    leftHand[0] = 2;
                    leftHand[1] = 1;
                } else if (right == left) {
                    if(hand.equals("right")) {
                        sb.append("R");
                        rightHand[0] = 2;
                        rightHand[1] = 1;
                    } else {
                        sb.append("L");
                        leftHand[0] = 2;
                        leftHand[1] = 1;
                    }
                }
            } else if(cur == 0) {
                int leftRow = Math.abs(leftHand[0] - 3);
                int leftCol = Math.abs(leftHand[1] - 1);
                int left = leftRow + leftCol;
                int rightRow = Math.abs(rightHand[0] - 3);
                int rightCol = Math.abs(rightHand[1] - 1);
                int right = rightRow + rightCol;
                if (left > right) {
                    sb.append("R");
                    rightHand[0] = 3;
                    rightHand[1] = 1;
                } else if (right > left) {
                    sb.append("L");
                    leftHand[0] = 3;
                    leftHand[1] = 1;
                } else if (right == left) {
                    if(hand.equals("right")) {
                        sb.append("R");
                        rightHand[0] = 3;
                        rightHand[1] = 1;
                    } else {
                        sb.append("L");
                        leftHand[0] = 3;
                        leftHand[1] = 1;
                    }
                }
            }
        }
        return sb.toString();
    }
}