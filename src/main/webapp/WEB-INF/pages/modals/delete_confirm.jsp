<div id="myModal" class="modal hide">
    <div class="modal-header">
        <a href="#" data-dismiss="modal" aria-hidden="true" class="close">×</a>
         <h3>Delete</h3>
    </div>
    <div class="modal-body">
        <p>You are about to delete.</p>
        <p>Do you want to proceed?</p>
    </div>
    <div class="modal-footer">
      <a href="#" id="btnYes" class="btn danger">Yes</a>
      <a href="#" data-dismiss="modal" aria-hidden="true" class="btn secondary">No</a>
    </div>
</div>
<script type="text/javascript">
$('#myModal').on('show', function() {
    var id = $(this).data('id'),
        removeBtn = $(this).find('.danger');
})

$('.confirm-delete').on('click', function(e) {
    e.preventDefault();

    var id = $(this).data('id');
    $('#myModal').data('id', id).modal('show');
});

$('#btnYes').click(function() {
    // handle deletion here
  	var id = $('#myModal').data('id');
  	$('[data-id='+id+']').remove();
  	$('#myModal').modal('hide');
});
</script>