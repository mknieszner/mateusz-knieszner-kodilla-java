package com.kodilla.testing.forum;

/**
 * Class provides comment methods and variables.
 */
public class ForumComment {
  private final ForumPost forumPost;
  private final String commentBody;
  private final String author;

  public ForumComment(final ForumPost forumPost, final String commentBody, final String author) {
    this.forumPost = forumPost;
    this.commentBody = commentBody;
    this.author = author;
  }

  public ForumPost getForumPost() {
    return forumPost;
  }

  public String getCommentBody() {
    return commentBody;
  }

  public String getAuthor() {
    return author;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    final ForumComment that = (ForumComment) o;

    if (!forumPost.equals(that.forumPost)) {
      return false;
    }
    if (!commentBody.equals(that.commentBody)) {
      return false;
    }
    return author.equals(that.author);
  }

  @Override
  public int hashCode() {
    int result = forumPost.hashCode();
    result = 31 * result + commentBody.hashCode();
    result = 31 * result + author.hashCode();
    return result;
  }
}
