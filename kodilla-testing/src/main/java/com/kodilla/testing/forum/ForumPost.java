package com.kodilla.testing.forum;

/**
 * Class provides post methods and variables.
 */
public class ForumPost {
    private final String postBody;
    private final String author;

    public ForumPost(final String postBody, final String author) {
        this.postBody = postBody;
        this.author = author;
    }

    public String getPostBody() {
        return postBody;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "ForumPost{" + "postBody='" + postBody + '\'' + ", author='" + author + '\'' + '}';
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ForumPost)) {
            return false;
        }

        final ForumPost forumPost = (ForumPost) o;

        if (!postBody.equals(forumPost.postBody)) {
            return false;
        }
        return author.equals(forumPost.author);
    }

    @Override
    public int hashCode() {
        int result = postBody.hashCode();
        result = 31 * result + author.hashCode();
        return result;
    }
}
