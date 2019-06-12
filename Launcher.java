// demand paging 사용(요청이 있을 때 그때그때 페이지를 로드)
// 주어진 page reference string을 입력받는다.
// 각 replacement기법으로 처리했을 때의 memory residence set의 변화과정 + page fault 발생과정 추적/출력 (chart사용)
// MIN : (미래에) 가장 나중에 쓸 애를 쫒아낸다. [동점자는(tie breaking rule) : page 번호가 크거나 작은 순으로 쫒아낸다.]
//  string을 돌면서 1개가 남을때까지 찾는 애를 victim에서 제거하고, 만약 다 돌았는데 2개 이상이면 그냥 큰 page번호를 고른다.
//  현재의 index 다음부터 끝까지 돈다.



// FIFO : (과거에) 가장 빨리 온 애를 쫒아낸다.
// 온 순서대로 쫒으므로 다음 쫒아낼 애의 프레임에서의 위치를 관리. 


// LRU : (과거에) 가장 옛날에 썼던 애를 쫒아낸다.
// 쓸때마다 그 시간을 기록한다.


// LFU : (과거에) 가장 덜 썼던 애를 쫒아낸다.
// 쓸때마다 사용횟수를 늘린다.


// WS Memory Management : Working Set을 사용해서 관리한다. (현재 요청한 애 + 현재부터 window size<delta> 전까지의 모든 page를 넣는다.)
// workingset은 일단 15개의 frame을 표현하고, 안쓰는 frame을 -1로 표시한다.
// 쓸 때마다 그 시간을 기록한 뒤에 현재의 workingset 중에 시간이 (현재-(delta+1)) 이하면 지운다.


// gui 창에서 모든 페이지를 표시하는 상황을 위해서 15 이상의 frame의 여유를 두고 표시해야 한다. (실제 할당 프레임 수도 같이 표시)
// 입력 : 프로세스의 페이지 갯수(종류) + 페이지 프레임 갯수(할당공간) + 윈도우 사이즈(WS기법) + page reference string 길이(바뀌는 페이지 양)

public class Launcher {
    

    // 테스트용
    int n = 15;
    int m = 4;
    int w = 3; 
    int k = 14;
    int[] reference_array ={1,2,6,1,4,5,1,2,1,4,5,6,4,5};
    int[][] MIN_matrix = new int[m+3][k];
    int[][] FIFO_matrix = new int[m+3][k];
    int[][] LRU_matrix = new int[m+3][k];
    int[][] LFU_matrix = new int[m+3][k];
    int[][] WS_matrix = new int[m+3][k];
    
    public static void main(String[] args) {
        // input 입력받아서 각 변수와 array에 넣기

        // time table 적기

        // reference string 채우기

        // matrix를 다 0으로 초기화(이미 되어있음)
        Launcher launcher = new Launcher();
        // MIN 함수 실행
        
        
        launcher.MIN_Handler();

        for (int i=0 ; i<4 ; i++) {

            for(int j=0 ; j<14 ; j++) {
                System.out.print(" "+launcher.MIN_matrix[i+2][j]+" "); 
            }
            System.out.println("");
        }

        // FIFO 함수 실행
        
        launcher.FIFO_Handler();

        for (int i=0 ; i<4 ; i++) {

            for(int j=0 ; j<14 ; j++) {
                System.out.print(" "+launcher.FIFO_matrix[i+2][j]+" "); 
            }
            System.out.println("");
        }

        // LRU 함수 실행

        // LFU 함수 실행

        // WS 함수 실행

    }
    int num_of_contents;//프레임에 있는 페이지 수

    boolean isFault;

    int [] Frame;//현재 프레임을 나타낸다.
    boolean isFull;//프레임이 다 찼는지 본다. (할당된 프레임 수 고정)

    void MIN_Handler() {
        int time = 0;
        Frame = new int[m];
        while(time<k) {
            isFault = true;
            for(int i=0 ; i<m ; i++) {
                if(reference_array[time]==Frame[i]) {//있으면 fault 아님
                    isFault=false;
                }
            }
            if(isFault) {//현재 없으면 replace해야하는지 확인
                if(!isFull) {//다 차있지 않으면 그냥 더하면 된다.
                    Frame[num_of_contents++] = reference_array[time];
                    if(num_of_contents==m) {
                        isFull=true;
                    }
                }
                else {//다 차있으면 replace해야한다.
                    Frame[MIN_replacer(time)]=reference_array[time];//
                }
            }
            for(int i=0 ; i<m ; i++) {
                MIN_matrix[i+2][time]=Frame[i];
            }
            time++;
        }
    }

    int MIN_replacer(int time) {
        int victim=0;
        boolean[] showed= new boolean[m];
        int first_show[]= new int[m];
        for(int i=0; i<m; i++){
            first_show[i]=Integer.MAX_VALUE;
        }
        
        for(int i=0; i<m; i++){//for each suspects
            for(int j=time; j<k; j++){//for each page state to reference string
                if (reference_array[j]==Frame[i]){
                    if (showed[i]==false){  //처음 찾은 경우만
                        first_show[i]=j-time;
                        showed[i]=true;
                    }
                }
            }
        }

        for(int k=m-1; k>=0; k--){ //최댓값이 큰 경우가 같으면 앞 페이지가 victim 이 되도록 하기 위해 거꾸로
                                   //the one with largest first_show value is the victim
            if (Frame[victim]<=first_show[k]){
                victim=k;
            
            }
        }
        
        return victim;
    }

    void FIFO_Handler() {
        int time = 0;
        int pointer = 0;//FIFO 기법 특징 : 다음에 넣을 위치를 index로 정한다. 넣을때마다 다음으로 넘겨준다.
        Frame = new int[m];
        while(time<k) {
            isFault = true;
            for(int i=0 ; i<m ; i++) {
                if(reference_array[time]==Frame[i]) {//있으면 fault 아님
                    isFault=false;
                }
            }
            if(isFault) {//현재 없으면 replace해야하는지 확인
                if(!isFull) {//다 차있지 않으면 그냥 더하면 된다.
                    Frame[num_of_contents++] = reference_array[time];
                    pointer = (pointer + 1) % m;//이렇게 하면 마지막에 넣을 때 다시 0으로 돌아간다. 
                    if(num_of_contents==m) {
                        isFull=true;
                    }
                }
                else {//다 차있으면 replace해야한다.
                    Frame[pointer] = reference_array[time];
                    pointer = (pointer + 1) % m;//이렇게 하면 마지막에 넣을 때 다시 0으로 돌아간다. 
                }
            }
            for(int i=0 ; i<m ; i++) {
                FIFO_matrix[i+2][time]=Frame[i];
            }
            time++;
        }
    }





    //FIFO는 쉬워서 replacer 없음

    int LRU_replacer() {
        int victim=-1;


        return victim;
    }

    int LFU_replacer() {
        int victim=-1;


        return victim;
    }

    int WS_replacer() {
        int victim=-1;


        return victim;
    }

    



}