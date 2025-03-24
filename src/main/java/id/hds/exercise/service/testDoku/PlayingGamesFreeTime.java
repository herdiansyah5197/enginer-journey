package id.hds.exercise.service.testDoku;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Slf4j
public class PlayingGamesFreeTime {

    //Created Method untuk mempertemukan waktu senggang
    // Upin dan ipin Sekarang memiliki kesibukan Belajar dan sekolah di tempat yang berbeda
    // Upin dan ipin ingin bertemu dan bermain games, mereka berdua ingin bermain bersama,
    // dengan mempertimbangkan waktu kosong dengan logic berikut
    // t adalah waktu main
    // a dan b adalah list waktu DAY startTime endTime

    public List<String> twoPersonMeetingSolution (int t, List<String> a, List<String> b){
        List<String> resp = new ArrayList<>();
        try{

            // convert list to day List<time>
            Map<Integer, List<int[]>> availableScheduleA = parseSchdeule(a);
            Map<Integer, List<int[]>> availabelScheduleB = parseSchdeule(b);

            // listdata availabel a dan b
            for(int day : availableScheduleA.keySet()){
                if(availabelScheduleB.containsKey(day)){
                    List<int[]> slotsA = availableScheduleA.get(day);
                    List<int[]> slotsB = availabelScheduleB.get(day);
                    for(int[] slotA:slotsA) {
                        for(int[] slotB : slotsB){
                            int start = Math.max(slotA[0], slotB[0]);
                            int end = Math.max(slotA[1], slotB[1]);
                            if(start-end >= t){
                                resp.add(day + " " + formatTime(start) + " " + formatTime(end));
                            }
                        }
                    }
                }
            }
        }catch (Exception e){
            log.error("Error soluton meeting");
            new Throwable();

        }
        return resp.isEmpty()? Collections.singletonList("tidak ada waktu senggang"):resp;
    }

    public Map<Integer, List<int[]>> parseSchdeule (List<String> schedule){
        Map<Integer, List<int[]>> map = new HashMap<>();

        for(String entity:schedule){
            String[] part = entity.split(" ");
            int day = Integer.parseInt(part[0]);
            int startTime = parseTime(part[1]);
            int endTime = parseTime(part[2]);
            map.putIfAbsent(day,new ArrayList<>());
            map.get(day).add(new int[]{startTime,endTime});
        }
        return map;

    }
    public int parseTime(String time){
        String [] part =time.split(":");
        return Integer.parseInt(part[0]) * 60 + Integer.parseInt(part[1]);
    }
    public String formatTime(int time){
        int hours = time/60;
        int minutes = time%60;
        return  String.format("%02d:%02d", hours, minutes);

    }


}
