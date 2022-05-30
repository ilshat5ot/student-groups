package com.sadykov.ilshat.students_groups.service;

import com.sadykov.ilshat.students_groups.dto.AddGroupRequestDto;
import com.sadykov.ilshat.students_groups.dto.AllGroupResponseDto;
import com.sadykov.ilshat.students_groups.entity.Group;
import com.sadykov.ilshat.students_groups.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    GroupRepository groupRepository;

    @Override
    public void addGroup(AddGroupRequestDto addGroupRequestDto) {
        Group group = new Group();
        group.setName(addGroupRequestDto.getName());
        groupRepository.save(group);
    }

    @Override
    public List<AllGroupResponseDto> getAllGroup(){
        List<Group> groupList = groupRepository.findAll();
        return groupList.stream()
                .map(this::getAllGroupResponseDtoFromGroup)
                .collect(Collectors.toList());
    }

    private AllGroupResponseDto getAllGroupResponseDtoFromGroup(Group group) {
        AllGroupResponseDto allGroupResponseDto = new AllGroupResponseDto();
        allGroupResponseDto.setId(group.getId());
        allGroupResponseDto.setName(group.getName());
        allGroupResponseDto.setStudentQuantity(group.getStudentList().size());
        return allGroupResponseDto;
    }

    @Override
    public Group getGroup(int id) {
        Group group = null;
        Optional<Group> optional = groupRepository.findById(id);
        if(optional.isPresent()){
            group = optional.get();
        }
        return group;
    }

}
