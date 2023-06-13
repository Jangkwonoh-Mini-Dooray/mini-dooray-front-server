package com.nhnacademy.minidooraygateway.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "backend.server")
@Getter
@Setter
public class UrlProperties {
    private String accountUrl;
    private String taskUrl;

    public String getMember() {
        return accountUrl + "/members/{member-id}";
    }
    public String getMemberByEmail() {
        return accountUrl + "/members/email/{email}";
    }
    public String createMember() {
        return accountUrl + "/members";
    }
    public String updateMember() {
        return accountUrl + "/members/{member-id}";
    }
    public String deleteMember() {
        return accountUrl + "/members/{member-id}";
    }


    public String getMemberAuthority() {
        return accountUrl + "/members/{member-id}/authority";
    }
    public String updateMemberAuthority() {
        return accountUrl + "/members/{member-id}/authority";
    }
    public String getMemberStatus() {
        return accountUrl + "/members/{member-id}/status";
    }
    public String updateMemberStatus() {
        return accountUrl + "/members/{member-id}/status";
    }


    public String getProjectByMemberId() {
        return taskUrl + "/projects/list/{member-id}";
    }
    public String getProjects() {
        return taskUrl + "/projects";
    }
    public String getProject() {
        return taskUrl + "/projects/{project-id}";
    }
    public String createProject() {
        return taskUrl + "/projects";
    }
    public String modifyProject() {
        return taskUrl + "/projects/{project-id}";
    }
    public String deleteProject() {
        return taskUrl + "/projects/{project-id}";
    }


    public String getProjectMembers() {
        return taskUrl + "/projects/{project-id}/members";
    }
    public String addProjectMembers() {
        return taskUrl + "/projects/{project-id}/members";
    }
    public String modifyProjectMembers() {
        return taskUrl + "/projects/{project-id}/members";
    }
    public String deleteProjectMembers() {
        return taskUrl + "/projects/{project-id}/members";
    }


    public String getProjectAuthorities() {
        return taskUrl + "/project-authority";
    }
    public String getProjectAuthority() {
        return taskUrl + "/project-authority/{projectAuthorityId}";
    }
    public String createProjectAuthority() {
        return taskUrl + "/project-authority";
    }
    public String updateProjectAuthority() {
        return taskUrl + "/project-authority/{projectAuthorityId}";
    }
    public String deleteProjectAuthority() {
        return taskUrl + "/project-authority/{projectAuthorityId}";
    }


    public String getProjectStatuses() {
        return taskUrl + "/project-status";
    }
    public String getProjectStatus() {
        return taskUrl + "/project-status/{projectStatusId}";
    }
    public String createProjectStatus() {
        return taskUrl + "/project-status";
    }
    public String updateProjectStatus() {
        return taskUrl + "/project-status/{projectStatusId}";
    }
    public String deleteProjectStatus() {
        return taskUrl + "/project-status/{projectStatusId}";
    }



    public String getTasks() {
        return taskUrl + "/projects/{project-id}/posts";
    }
    public String getTask() {
        return taskUrl + "/projects/{project-id}/posts/{task-id}";
    }
    public String createTask() {
        return taskUrl + "/projects/{project-id}/posts";
    }
    public String modifyTask() {
        return taskUrl + "/projects/{project-id}/posts/{task-id}";
    }
    public String deleteTask() {
        return taskUrl + "/projects/posts/{task-id}";
    }


    public String getMilestones() {
        return taskUrl + "/milestones/projects/{project-id}";
    }
    public String getMilestone() {
        return taskUrl + "/milestones/{milestone-id}";
    }
    public String createMilestone() {
        return taskUrl + "/milestones/projects/{project-id}";
    }
    public String modifyMilestone() {
        return taskUrl + "/milestones/{milestone-id}";
    }
    public String deleteMilestone() {
        return taskUrl + "/milestones/{milestone-id}";
    }


    public String getTags() {
        return taskUrl + "/projects/{project-id}/tags";
    }
    public String getTagsByTags() {
        return taskUrl + "/projects/{project-id}/tags/{task-id}";
    }
    public String createTag() {
        return taskUrl + "/projects/{project-id}/tags";
    }
    public String modifyTag() {
        return taskUrl + "/projects/{project-id}/tags/{tag-id}";
    }
    public String deleteTag() {
        return taskUrl + "/projects/tags/{tag-id}";
    }


    public String getComments() {
        return taskUrl + "/task/{task-id}/comments";
    }
    public String postComment() {
        return taskUrl + "/task/{task-id}/comments";
    }
    public String putComment() {
        return taskUrl + "/task/comments/{comment-id}";
    }
    public String deleteComment() {
        return taskUrl + "/task/comments/{comment-id}";
    }


    public String getCommentMentions() {
        return taskUrl + "/mentions/{comment-id}";
    }
    public String createCommentMention() {
        return taskUrl + "/mentions/{comment-id}";
    }
    public String modifyCommentMention() {
        return taskUrl + "/mentions/{comment-id}";
    }
    public String deleteCommentMention() {
        return taskUrl + "/mentions/{comment-id}";
    }
}
