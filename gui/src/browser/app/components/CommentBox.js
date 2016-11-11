import React from 'react';
import Button from './Button';

const CommentBox = ({ ...props }: Props) => {
    const postConference = () => {
          var xhttp = new XMLHttpRequest();
          xhttp.open("POST", "/api/conference", true);
          xhttp.setRequestHeader("Content-type", "application/json");
          xhttp.send('{"name": "Foo"}');
    };

    return (
        <div className="commentBox">
            <p>Hello, conference world! I am a CommentBox.</p>
            <Button onClick={postConference}>POST Conference</Button>
        </div>
    );
};

export default CommentBox

