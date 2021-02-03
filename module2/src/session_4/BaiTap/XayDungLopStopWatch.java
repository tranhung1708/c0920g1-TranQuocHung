package session_4.BaiTap;

public class XayDungLopStopWatch {
    public static class StopWatch {
        private long startTime, endTime;

        public StopWatch() {
            startTime = System.currentTimeMillis();
        }

        public long getStartTime() {
            return startTime;
        }

        public long getEndTime() {
            return endTime;
        }

        public long start() {
            return this.startTime = System.currentTimeMillis();
        }

        public long stop() {
            return this.endTime = System.currentTimeMillis();
        }

        public long getElapsedTime() {
            return this.endTime - this.startTime;
        }

    }

    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        int a = 0;
        for (int i = 0; i < 1000000000; i++) {
            for (int j = 0; j < 1000000000; j++) {
                a += 1;
            }
        }
        stopWatch.stop();
        System.out.println(stopWatch.getElapsedTime());
    }
}
