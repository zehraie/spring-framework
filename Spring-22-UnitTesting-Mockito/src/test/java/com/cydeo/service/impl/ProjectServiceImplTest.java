package com.cydeo.service.impl;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.entity.Project;
import com.cydeo.mapper.ProjectMapper;
import com.cydeo.repository.ProjectRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProjectServiceImplTest {
    @Mock
    ProjectRepository projectRepository;
    @Mock
    ProjectMapper projectMapper;
    @InjectMocks
    ProjectServiceImpl projectService;
    @Test
    void getByProjectCode_test(){
        //Given
        Project project = new Project();
        ProjectDTO projectDTO =new ProjectDTO();
        when(projectRepository.findByProjectCode(anyString())).thenReturn(project);
       when(projectMapper.convertToDto(project)).thenReturn(projectDTO);

      //When
        ProjectDTO projectDTO1 = projectService.getByProjectCode(anyString());

        //Then
        verify(projectRepository).findByProjectCode(anyString());
        verify(projectMapper).convertToDto(any(Project.class)); // import any()
      //  verify(projectMapper).convertToDto(project); //yukaridaki ile ayni sonucu veriyor

        assertNotNull(projectDTO1);
    }

    @Test
    void getByProjectCode_exception_test(){
        when(projectRepository.findByProjectCode("")).thenThrow(new RuntimeException("Project Not Found"));
        Throwable  exception = assertThrows(RuntimeException.class, ()->projectService.getByProjectCode(""));
        verify(projectRepository).findByProjectCode(anyString());
        assertEquals(exception.getMessage(),"Project Not Found");
    }
    @Test
    void save_test(){
        ProjectDTO projectDTO = new ProjectDTO();
        Project project = new Project();
        when(projectMapper.convertToEntity(projectDTO)).thenReturn(project);
        when(projectRepository.save(project)).thenReturn(project);

        projectService.save(projectDTO);
        verify(projectRepository).save(project);
        verify(projectMapper).convertToEntity(any(ProjectDTO.class));
/*
@Override
    public void save(ProjectDTO dto) {
   dto.setProjectStatus(Status.OPEN);
   Project project = projectMapper.convertToEntity(dto);
   projectRepository.save(project);
    }
 */
    }

}
/*  dofor this method  , I need to mock only for two projectMapper and projectRepository
 @Override
    public ProjectDTO getByProjectCode(String code) {
        Project project = projectRepository.findByProjectCode(code);
        return projectMapper.convertToDto(project);
    }

 */