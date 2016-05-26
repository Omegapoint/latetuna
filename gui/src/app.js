var CommentBox = React.createClass({
  render: function() {
    return (
      <div className="commentBox">
        <p>Hello, conference world! I am a CommentBox.</p>
        <button>POST Conference</button>
      </div>
    );
  }
});
ReactDOM.render(
  <CommentBox />,
  document.getElementById('content')
);
