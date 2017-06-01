<div class="ui small modal" id="rentingModal">
	<div class="header">Renting Book</div>
	<div class="content">
		<div class="ui middle aligned divided big list" id="list-rented-book">
			
		</div>
		<h4 class="ui horizontal divider header">
			<i class="tag icon"></i> Payment
		</h4>
		<div class="ui form">
			<div class="two fields">
				<div class="field">
					<label>Full Name</label> <input type="text" placeholder="FullName" id="fullName">
				</div>
				<div class="field">
					<label>Phone</label> <input type="text" placeholder="Phone number" id="phoneNumber">
				</div>
			</div>
			<div class="field">
				<label>Address</label> <input type="text" placeholder="Address" id="address">
			</div>
			<div class="two fields">
				<div class="field">
					<label>Borrowed Day</label>
					<div class="ui calendar" id="borrowedDay">
			          <div class="ui input left icon">
			            <i class="calendar icon"></i>
			            <input type="text" placeholder="Start">
			          </div>
			        </div>
				</div>
				<div class="field">
					<label>Return Day</label>
					<div class="ui calendar" id="returnDay">
			          <div class="ui input left icon">
			            <i class="calendar icon"></i>
			            <input type="text" placeholder="End">
			          </div>
			        </div>
				</div>
			</div>
			<div class="field">
				<label>Note</label>
				<textarea rows="2" id="note"></textarea>
			</div>
		</div>
	</div>
	<div class="actions">
		<div class="ui right labeled icon button" id="renting-btn">
			Rent <i class="checkmark icon"></i>
		</div>
		<div class="ui primary cancel right labeled icon button">
			Back <i class="share icon"></i>
		</div>
	</div>
</div>