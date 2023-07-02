package com.cydeo.service.impl;

import com.cydeo.dto.TaskDTO;
import com.cydeo.entity.Project;
import com.cydeo.entity.Role;
import com.cydeo.entity.Task;
import com.cydeo.entity.User;
import com.cydeo.enums.Gender;
import com.cydeo.enums.Status;
import com.cydeo.mapper.ProjectMapper;
import com.cydeo.mapper.TaskMapper;
import com.cydeo.repository.TaskRepository;
import com.cydeo.repository.UserRepository;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ContextConfiguration(classes = {TaskServiceImpl.class})
@ExtendWith(MockitoExtension.class)
class TaskServiceImplTest {
    @MockBean
    private ProjectMapper projectMapper;

    @Autowired
    private TaskServiceImpl taskServiceImpl;

    @MockBean
    private UserRepository userRepository;

    @Mock
    TaskRepository taskRepository;
    @Mock
    TaskMapper taskMapper;
    @InjectMocks
    TaskServiceImpl taskService;

    @ParameterizedTest
    @ValueSource(longs = {1L, 2L, 3L})
    void findById_test(long id) {
        //Given
        Task task = new Task();

        when(taskRepository.findById(id)).thenReturn(Optional.of(task));
        when(taskMapper.convertToDTO(task)).thenReturn(new TaskDTO());// yukarida instance da creaete yapabilirdik new TaskDTO() yerine
        //When
        taskService.findById(id);
        //Then
        verify(taskRepository).findById(id);
        verify(taskRepository).findById(anyLong());

        verify(taskMapper).convertToDTO(any(Task.class));
        verify(taskMapper).convertToDTO(task);

        //  verify(taskRepository,never()).findById(-5L);
    }

    @Test
    void findById_bdd_test() {
        //Given
        Task task = new Task();
//given mockitoBDD be carefull  !!!!!!!!!
        given(taskRepository.findById(anyLong())).willReturn(Optional.of(task));
        given(taskMapper.convertToDTO(task)).willReturn(new TaskDTO());
        //When
        taskService.findById(anyLong());

        //Then
        then(taskRepository).should().findById(anyLong());
        then(taskRepository).should(never()).findById(-5L);
    }

    /**
     * Method under test: {@link TaskServiceImpl#update(TaskDTO)}
     */
//    @Test
//    void testUpdate() {
//        Role role = new Role();
//        role.setDescription("The characteristics of someone or something");
//        role.setId(1L);
//        role.setInsertDateTime(LocalDate.of(1970, 1, 1).atStartOfDay());
//        role.setInsertUserId(1L);
//        role.setIsDeleted(true);
//        role.setLastUpdateDateTime(LocalDate.of(1970, 1, 1).atStartOfDay());
//        role.setLastUpdateUserId(1L);
//
//        User assignedEmployee = new User();
//        assignedEmployee.setEnabled(true);
//        assignedEmployee.setFirstName("Jane");
//        assignedEmployee.setGender(Gender.MALE);
//        assignedEmployee.setId(1L);
//        assignedEmployee.setInsertDateTime(LocalDate.of(1970, 1, 1).atStartOfDay());
//        assignedEmployee.setInsertUserId(1L);
//        assignedEmployee.setIsDeleted(true);
//        assignedEmployee.setLastName("Doe");
//        assignedEmployee.setLastUpdateDateTime(LocalDate.of(1970, 1, 1).atStartOfDay());
//        assignedEmployee.setLastUpdateUserId(1L);
//        assignedEmployee.setPassWord("Pass Word");
//        assignedEmployee.setPhone("6625550144");
//        assignedEmployee.setRole(role);
//        assignedEmployee.setUserName("janedoe");
//
//        Role role2 = new Role();
//        role2.setDescription("The characteristics of someone or something");
//        role2.setId(1L);
//        role2.setInsertDateTime(LocalDate.of(1970, 1, 1).atStartOfDay());
//        role2.setInsertUserId(1L);
//        role2.setIsDeleted(true);
//        role2.setLastUpdateDateTime(LocalDate.of(1970, 1, 1).atStartOfDay());
//        role2.setLastUpdateUserId(1L);
//
//        User assignedManager = new User();
//        assignedManager.setEnabled(true);
//        assignedManager.setFirstName("Jane");
//        assignedManager.setGender(Gender.MALE);
//        assignedManager.setId(1L);
//        assignedManager.setInsertDateTime(LocalDate.of(1970, 1, 1).atStartOfDay());
//        assignedManager.setInsertUserId(1L);
//        assignedManager.setIsDeleted(true);
//        assignedManager.setLastName("Doe");
//        assignedManager.setLastUpdateDateTime(LocalDate.of(1970, 1, 1).atStartOfDay());
//        assignedManager.setLastUpdateUserId(1L);
//        assignedManager.setPassWord("Pass Word");
//        assignedManager.setPhone("6625550144");
//        assignedManager.setRole(role2);
//        assignedManager.setUserName("janedoe");
//
//        Project project = new Project();
//        project.setAssignedManager(assignedManager);
//        project.setEndDate(LocalDate.of(1970, 1, 1));
//        project.setId(1L);
//        project.setInsertDateTime(LocalDate.of(1970, 1, 1).atStartOfDay());
//        project.setInsertUserId(1L);
//        project.setIsDeleted(true);
//        project.setLastUpdateDateTime(LocalDate.of(1970, 1, 1).atStartOfDay());
//        project.setLastUpdateUserId(1L);
//        project.setProjectCode("Project Code");
//        project.setProjectDetail("Project Detail");
//        project.setProjectName("Project Name");
//        project.setProjectStatus(Status.OPEN);
//        project.setStartDate(LocalDate.of(1970, 1, 1));
//
//        Task task = new Task();
//        task.setAssignedDate(LocalDate.of(1970, 1, 1));
//        task.setAssignedEmployee(assignedEmployee);
//        task.setId(1L);
//        task.setInsertDateTime(LocalDate.of(1970, 1, 1).atStartOfDay());
//        task.setInsertUserId(1L);
//        task.setIsDeleted(true);
//        task.setLastUpdateDateTime(LocalDate.of(1970, 1, 1).atStartOfDay());
//        task.setLastUpdateUserId(1L);
//        task.setProject(project);
//        task.setTaskDetail("Task Detail");
//        task.setTaskStatus(Status.OPEN);
//        task.setTaskSubject("Hello from the Dreaming Spires");
//        Optional<Task> ofResult = Optional.of(task);
//
//        Role role3 = new Role();
//        role3.setDescription("The characteristics of someone or something");
//        role3.setId(1L);
//        role3.setInsertDateTime(LocalDate.of(1970, 1, 1).atStartOfDay());
//        role3.setInsertUserId(1L);
//        role3.setIsDeleted(true);
//        role3.setLastUpdateDateTime(LocalDate.of(1970, 1, 1).atStartOfDay());
//        role3.setLastUpdateUserId(1L);
//
//        User assignedEmployee2 = new User();
//        assignedEmployee2.setEnabled(true);
//        assignedEmployee2.setFirstName("Jane");
//        assignedEmployee2.setGender(Gender.MALE);
//        assignedEmployee2.setId(1L);
//        assignedEmployee2.setInsertDateTime(LocalDate.of(1970, 1, 1).atStartOfDay());
//        assignedEmployee2.setInsertUserId(1L);
//        assignedEmployee2.setIsDeleted(true);
//        assignedEmployee2.setLastName("Doe");
//        assignedEmployee2.setLastUpdateDateTime(LocalDate.of(1970, 1, 1).atStartOfDay());
//        assignedEmployee2.setLastUpdateUserId(1L);
//        assignedEmployee2.setPassWord("Pass Word");
//        assignedEmployee2.setPhone("6625550144");
//        assignedEmployee2.setRole(role3);
//        assignedEmployee2.setUserName("janedoe");
//
//        Role role4 = new Role();
//        role4.setDescription("The characteristics of someone or something");
//        role4.setId(1L);
//        role4.setInsertDateTime(LocalDate.of(1970, 1, 1).atStartOfDay());
//        role4.setInsertUserId(1L);
//        role4.setIsDeleted(true);
//        role4.setLastUpdateDateTime(LocalDate.of(1970, 1, 1).atStartOfDay());
//        role4.setLastUpdateUserId(1L);
//
//        User assignedManager2 = new User();
//        assignedManager2.setEnabled(true);
//        assignedManager2.setFirstName("Jane");
//        assignedManager2.setGender(Gender.MALE);
//        assignedManager2.setId(1L);
//        assignedManager2.setInsertDateTime(LocalDate.of(1970, 1, 1).atStartOfDay());
//        assignedManager2.setInsertUserId(1L);
//        assignedManager2.setIsDeleted(true);
//        assignedManager2.setLastName("Doe");
//        assignedManager2.setLastUpdateDateTime(LocalDate.of(1970, 1, 1).atStartOfDay());
//        assignedManager2.setLastUpdateUserId(1L);
//        assignedManager2.setPassWord("Pass Word");
//        assignedManager2.setPhone("6625550144");
//        assignedManager2.setRole(role4);
//        assignedManager2.setUserName("janedoe");
//
//        Project project2 = new Project();
//        project2.setAssignedManager(assignedManager2);
//        project2.setEndDate(LocalDate.of(1970, 1, 1));
//        project2.setId(1L);
//        project2.setInsertDateTime(LocalDate.of(1970, 1, 1).atStartOfDay());
//        project2.setInsertUserId(1L);
//        project2.setIsDeleted(true);
//        project2.setLastUpdateDateTime(LocalDate.of(1970, 1, 1).atStartOfDay());
//        project2.setLastUpdateUserId(1L);
//        project2.setProjectCode("Project Code");
//        project2.setProjectDetail("Project Detail");
//        project2.setProjectName("Project Name");
//        project2.setProjectStatus(Status.OPEN);
//        project2.setStartDate(LocalDate.of(1970, 1, 1));
//
//        Task task2 = new Task();
//        task2.setAssignedDate(LocalDate.of(1970, 1, 1));
//        task2.setAssignedEmployee(assignedEmployee2);
//        task2.setId(1L);
//        task2.setInsertDateTime(LocalDate.of(1970, 1, 1).atStartOfDay());
//        task2.setInsertUserId(1L);
//        task2.setIsDeleted(true);
//        task2.setLastUpdateDateTime(LocalDate.of(1970, 1, 1).atStartOfDay());
//        task2.setLastUpdateUserId(1L);
//        task2.setProject(project2);
//        task2.setTaskDetail("Task Detail");
//        task2.setTaskStatus(Status.OPEN);
//        task2.setTaskSubject("Hello from the Dreaming Spires");
//        when(taskRepository.save(Mockito.<Task>any())).thenReturn(task2);
//        when(taskRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);
//
//        Role role5 = new Role();
//        role5.setDescription("The characteristics of someone or something");
//        role5.setId(1L);
//        role5.setInsertDateTime(LocalDate.of(1970, 1, 1).atStartOfDay());
//        role5.setInsertUserId(1L);
//        role5.setIsDeleted(true);
//        role5.setLastUpdateDateTime(LocalDate.of(1970, 1, 1).atStartOfDay());
//        role5.setLastUpdateUserId(1L);
//
//        User assignedEmployee3 = new User();
//        assignedEmployee3.setEnabled(true);
//        assignedEmployee3.setFirstName("Jane");
//        assignedEmployee3.setGender(Gender.MALE);
//        assignedEmployee3.setId(1L);
//        assignedEmployee3.setInsertDateTime(LocalDate.of(1970, 1, 1).atStartOfDay());
//        assignedEmployee3.setInsertUserId(1L);
//        assignedEmployee3.setIsDeleted(true);
//        assignedEmployee3.setLastName("Doe");
//        assignedEmployee3.setLastUpdateDateTime(LocalDate.of(1970, 1, 1).atStartOfDay());
//        assignedEmployee3.setLastUpdateUserId(1L);
//        assignedEmployee3.setPassWord("Pass Word");
//        assignedEmployee3.setPhone("6625550144");
//        assignedEmployee3.setRole(role5);
//        assignedEmployee3.setUserName("janedoe");
//
//        Role role6 = new Role();
//        role6.setDescription("The characteristics of someone or something");
//        role6.setId(1L);
//        role6.setInsertDateTime(LocalDate.of(1970, 1, 1).atStartOfDay());
//        role6.setInsertUserId(1L);
//        role6.setIsDeleted(true);
//        role6.setLastUpdateDateTime(LocalDate.of(1970, 1, 1).atStartOfDay());
//        role6.setLastUpdateUserId(1L);
//
//        User assignedManager3 = new User();
//        assignedManager3.setEnabled(true);
//        assignedManager3.setFirstName("Jane");
//        assignedManager3.setGender(Gender.MALE);
//        assignedManager3.setId(1L);
//        assignedManager3.setInsertDateTime(LocalDate.of(1970, 1, 1).atStartOfDay());
//        assignedManager3.setInsertUserId(1L);
//        assignedManager3.setIsDeleted(true);
//        assignedManager3.setLastName("Doe");
//        assignedManager3.setLastUpdateDateTime(LocalDate.of(1970, 1, 1).atStartOfDay());
//        assignedManager3.setLastUpdateUserId(1L);
//        assignedManager3.setPassWord("Pass Word");
//        assignedManager3.setPhone("6625550144");
//        assignedManager3.setRole(role6);
//        assignedManager3.setUserName("janedoe");
//
//        Project project3 = new Project();
//        project3.setAssignedManager(assignedManager3);
//        project3.setEndDate(LocalDate.of(1970, 1, 1));
//        project3.setId(1L);
//        project3.setInsertDateTime(LocalDate.of(1970, 1, 1).atStartOfDay());
//        project3.setInsertUserId(1L);
//        project3.setIsDeleted(true);
//        project3.setLastUpdateDateTime(LocalDate.of(1970, 1, 1).atStartOfDay());
//        project3.setLastUpdateUserId(1L);
//        project3.setProjectCode("Project Code");
//        project3.setProjectDetail("Project Detail");
//        project3.setProjectName("Project Name");
//        project3.setProjectStatus(Status.OPEN);
//        project3.setStartDate(LocalDate.of(1970, 1, 1));
//
//        Task task3 = new Task();
//        task3.setAssignedDate(LocalDate.of(1970, 1, 1));
//        task3.setAssignedEmployee(assignedEmployee3);
//        task3.setId(1L);
//        task3.setInsertDateTime(LocalDate.of(1970, 1, 1).atStartOfDay());
//        task3.setInsertUserId(1L);
//        task3.setIsDeleted(true);
//        task3.setLastUpdateDateTime(LocalDate.of(1970, 1, 1).atStartOfDay());
//        task3.setLastUpdateUserId(1L);
//        task3.setProject(project3);
//        task3.setTaskDetail("Task Detail");
//        task3.setTaskStatus(Status.OPEN);
//        task3.setTaskSubject("Hello from the Dreaming Spires");
//        when(taskMapper.convertToEntity(Mockito.<TaskDTO>any())).thenReturn(task3);
//        taskServiceImpl.update(new TaskDTO());
//        verify(taskRepository).save(Mockito.<Task>any());
//        verify(taskRepository).findById(Mockito.<Long>any());
//        verify(taskMapper).convertToEntity(Mockito.<TaskDTO>any());
//    }
}
/*
    @Override
    public TaskDTO findById(Long id) {

        Optional<Task> task = taskRepository.findById(id);
        if(task.isPresent()){
            return taskMapper.convertToDTO(task.get());
        }
        return null ;
    }
 */