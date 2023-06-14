package com.nhnacademy.minidooraygateway.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "gateway.server")
@Getter
@Setter
public class UrlProperties {
    private String url;

    public String getMember() {
        return url + "/members/{member-id}";
    }
    public String getMemberByEmail() {
        return url + "/members/email/{email}";
    }
    public String createMember() {
        return url + "/members";
    }
    public String updateMember() {
        return url + "/members/{member-id}";
    }
    public String deleteMember() {
        return url + "/members/{member-id}";
    }


    public String getMemberAuthority() {
        return url + "/members/{member-id}/authority";
    }
    public String updateMemberAuthority() {
        return url + "/members/{member-id}/authority";
    }
    public String getMemberStatus() {
        return url + "/members/{member-id}/status";
    }
    public String updateMemberStatus() {
        return url + "/members/{member-id}/status";
    }


    public String getProjectByMemberId() {
        return url + "/projects/list/{member-id}";
    }
    public String getProjects() {
        return url + "/projects";
    }
    public String getProject() {
        return url + "/projects/{project-id}";
    }
    public String createProject() {
        return url + "/projects";
    }
    public String modifyProject() {
        return url + "/projects/{project-id}";
    }
    public String deleteProject() {
        return url + "/projects/{project-id}";
    }


    public String getProjectMembers() {
        return url + "/projects/{project-id}/members";
    }
    public String addProjectMembers() {
        return url + "/projects/{project-id}/members";
    }
    public String modifyProjectMembers() {
        return url + "/projects/{project-id}/members";
    }
    public String deleteProjectMembers() {
        return url + "/projects/{project-id}/members";
    }


    public String getProjectAuthorities() {
        return url + "/project-authority";
    }
    public String getProjectAuthority() {
        return url + "/project-authority/{projectAuthorityId}";
    }
    public String createProjectAuthority() {
        return url + "/project-authority";
    }
    public String updateProjectAuthority() {
        return url + "/project-authority/{projectAuthorityId}";
    }
    public String deleteProjectAuthority() {
        return url + "/project-authority/{projectAuthorityId}";
    }


    public String getProjectStatuses() {
        return url + "/project-status";
    }
    public String getProjectStatus() {
        return url + "/project-status/{projectStatusId}";
    }
    public String createProjectStatus() {
        return url + "/project-status";
    }
    public String updateProjectStatus() {
        return url + "/project-status/{projectStatusId}";
    }
    public String deleteProjectStatus() {
        return url + "/project-status/{projectStatusId}";
    }



    public String getTasks() {
        return url + "/projects/{project-id}/posts";
    }
    public String getTask() {
        return url + "/projects/{project-id}/posts/{task-id}";
    }
    public String createTask() {
        return url + "/projects/{project-id}/posts";
    }
    public String modifyTask() {
        return url + "/projects/{project-id}/posts/{task-id}";
    }
    public String deleteTask() {
        return url + "/projects/posts/{task-id}";
    }


    public String getMilestones() {
        return url + "/milestones/projects/{project-id}";
    }
    public String getMilestone() {
        return url + "/milestones/{milestone-id}";
    }
    public String createMilestone() {
        return url + "/milestones/projects/{project-id}";
    }
    public String modifyMilestone() {
        return url + "/milestones/{milestone-id}";
    }
    public String deleteMilestone() {
        return url + "/milestones/{milestone-id}";
    }


    public String getTags() {
        return url + "/projects/{project-id}/tags";
    }
    public String getTagsByTags() {
        return url + "/projects/{project-id}/tags/{task-id}";
    }
    public String createTag() {
        return url + "/projects/{project-id}/tags";
    }
    public String modifyTag() {
        return url + "/projects/{project-id}/tags/{tag-id}";
    }
    public String deleteTag() {
        return url + "/projects/tags/{tag-id}";
    }


    public String getComments() {
        return url + "/task/{task-id}/comments";
    }
    public String postComment() {
        return url + "/task/{task-id}/comments";
    }
    public String putComment() {
        return url + "/task/comments/{comment-id}";
    }
    public String deleteComment() {
        return url + "/task/comments/{comment-id}";
    }


    public String getCommentMentions() {
        return url + "/mentions/{comment-id}";
    }
    public String createCommentMention() {
        return url + "/mentions/{comment-id}";
    }
    public String modifyCommentMention() {
        return url + "/mentions/{comment-id}";
    }
    public String deleteCommentMention() {
        return url + "/mentions/{comment-id}";
    }
}
