package com.kodilla.testing.forum;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Class provides forum users methods and variables.
 */
public class ForumUser {
  private final String name;
  private final String realName;
  private final List<ForumPost> posts = new ArrayList<ForumPost>();
  private final List<ForumComment> comments = new LinkedList<ForumComment>();

  public ForumUser(final String name, final String realName) {
    this.name = name;
    this.realName = realName;
  }

  public int getPostsQuantity() {
    return posts.size();
  }

  public void addPost(final String author, final String postBody) {
    final ForumPost thePost = new ForumPost(postBody, author);
    posts.add(thePost);
  }

  public int getCommentsQuantity() {
    return comments.size();
  }

  public void addComment(final ForumPost thePost, final String author, final String commentBody) {
    final ForumComment theComment = new ForumComment(thePost, commentBody, author);
    comments.add(theComment);
  }

  public ForumPost getPost(final int postNumber) {
    ForumPost thePost = null;
    if (postNumber >= 0 && postNumber < posts.size()) {
      thePost = posts.get(postNumber);
    }
    return thePost;
  }

  public ForumComment getComment(final int commentNumber) {
    ForumComment theComment = null;
    if (commentNumber >= 0 && commentNumber < comments.size()) {
      theComment = comments.get(commentNumber);
    }
    return theComment;
  }

  public boolean removePost(final ForumPost thePost) {
    boolean result = false;
    if (posts.contains(thePost)) {
      posts.remove(thePost);
      result = true;
    }
    return result;
  }

  public boolean removeComment(final ForumComment theComment) {
    boolean result = false;
    if (comments.contains(theComment)) {
      comments.remove(theComment);
      result = true;
    }
    return result;
  }

  public String getName() {
    return name;
  }

  public String getRealName() {
    return realName;
  }
}
