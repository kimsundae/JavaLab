package practice_Stream;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamPractice_ofProject {

}
/*
    호텔 프로젝트에서 사용한 스트림 필터

    public List<RoomReservationDto> getRoomReservation(RoomSearchDto roomSearchDto){


        // String으로 받은 날짜를 LocalDate로 파싱
        LocalDate startdate = null, enddate = null;
        if( !roomSearchDto.getRrstartdate().isEmpty() )
            startdate = LocalDate.parse( roomSearchDto.getRrstartdate() , DateTimeFormatter.ISO_DATE );
        if( !roomSearchDto.getRrenddate().isEmpty() )
            enddate = LocalDate.parse( roomSearchDto.getRrenddate() , DateTimeFormatter.ISO_DATE );
        // forEach 사용 시 상수여야 함.
        // 그러므로 LocalDate로 파싱한 변수들을 상수에 담음.
        final LocalDate finalStartDate = startdate;
        final LocalDate finalEnddate = enddate;
        */
/*  keyword의 전화번호, 이름, 호실 판단 로직
         *   type엔 keyword가 이름, 호실, 전화번호, 공백 중 하나가 들어있음
         * *//*

        final String keyword = roomSearchDto.getKeyword();
        final String type = aboutType(keyword);

        // 모든 예약 정보 호출 -------------------------------------------------------------
        List<RoomReservationEntity> entities= roomReservationEntityRepository.findAll();
        // 예약정보 스트림 생성
        Stream<RoomReservationEntity> entityStream = entities.stream();
        */
/*
         * 날짜 필터링
         *   1. 입력 날짜가 시작 날짜, 종료 날짜 둘 다 존재할 경우
         *   2. 입력 날짜만 존재할 경우
         *   3. 종료 날짜만 존재할 경우
         * 등급 필터링
         *   1. 등급이 선택되지 않은 경우
         *   2. 등급이 선택된 경우
         * 키워드 필터링
         *   1. 키워드 type이 어떤 것인지
         * 페이지 필터링
         * *//*

        // 시작 날짜, 종료 날짜 둘 다 null이 아니면
        if( finalStartDate != null || finalEnddate != null ) {
            entities = entityStream
                    //날짜 필터
                    .filter(
                            entity ->
                                    finalStartDate != null && finalEnddate != null ?
                                            entity.getRrstartdate().isAfter(finalStartDate) && entity.getRrenddate().isBefore(finalEnddate) :
                                            finalStartDate != null ? entity.getRrstartdate().isEqual(finalStartDate) :
                                                    entity.getRrenddate().isEqual(finalEnddate)).collect(Collectors.toList());
            entityStream = entities.stream();
        }
        // 등급 필터
        if( !"Nonselect".equals(roomSearchDto.getGname()) ) {
            entities = entityStream.filter(
                    entity ->
                            entity.getRoomEntity().getRoomGradeEntity().getRgname().equals(
                                    roomSearchDto.getGname())).collect(Collectors.toList());
            entityStream = entities.stream();
        }
        // 키워드 필터
        if( type != null ) {
            entities = entityStream.filter(
                    entity -> {
                        if ("rno".equals(type)) {
                            final int keywordEqualRno = Integer.parseInt(keyword);
                            return entity.getRoomEntity().getRno() == keywordEqualRno;
                        } else if ("mname".equals(type)) return entity.getMemberInfoEntity().getMname().equals(keyword);
                        else return entity.getMemberInfoEntity().getMphone().equals(keyword);
                    }).collect(Collectors.toList());
        }
        // dto 변환 후 반환
        List<RoomReservationDto> roomDtoList = new ArrayList<>();
        for( RoomReservationEntity entity : entities ) roomDtoList.add(entity.toDto());
        return roomDtoList;
    }*/
