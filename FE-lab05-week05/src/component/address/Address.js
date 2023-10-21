import { Button, Pagination, Typography, useMediaQuery, useTheme } from '@mui/material';
import React, { useEffect, useState } from 'react';

import AddCircleIcon from '@mui/icons-material/AddCircle';
import { createAddress, getAlladdressPage, updateAddress } from '../../services/AddressServices'
import ModalCreate from './ModalCreate';
import ModalUpdate from './ModalUpdate';

import { useSnackbar } from 'notistack';
import TableAddress from './TableAddress';
import "./Address.scss"
import _ from 'lodash';

const Address = () => {

    const { enqueueSnackbar } = useSnackbar();
    const [dataall, setdataall] = useState([]);
    const [dataaddress, setdataaddress] = useState([]);
    const [opencreate, setopencreate] = useState(false);
    const [openupdate, setopenupdate] = useState(false);
    const [pages, setpage] = useState(1);
    const [dataupdate, setdataupdate] = useState({});

    const theme = useTheme();
    const ismobile = useMediaQuery(theme.breakpoints.down("sm"))

    const getAlladdresss = async () => {
        let data = await getAlladdressPage(pages - 1, 10);
        if (data && data.data) {
            setdataall(data.data);
            if (data && data.data && data.data.content.length > 0)
                setdataaddress(data.data.content)
        }
    }

    const createaddress = async (data) => {
        let res = await createAddress(data);
        if (res && res.data.status === 200) {
            enqueueSnackbar("create address is success!", { variant: "success" });
            setopencreate(false)
            getAlladdresss();
        }
        else {
            enqueueSnackbar("create address is error!", { variant: "error" });
            getAlladdresss();
        }
    }

    const handleChangPage = (event, value) => {
        setpage(value)
    }

    const handleUpdate = async (data) => {
        if (data && !_.isEmpty(data)) {
            setdataupdate(data);
        }
    }

    const handleUpdateModal = async (data) => {
        if (data && !_.isEmpty(data)) {
            let res = await updateAddress(data);
            if (res && res.data.status === 200) {
                enqueueSnackbar("update address is success!", { variant: "success" });
                setopenupdate(false)
                getAlladdresss();
            }
        } else {
            enqueueSnackbar("create address is error!", { variant: "error" });
            getAlladdresss();
        }
    }

    useEffect(() => {
        getAlladdresss();

    }, [])


    useEffect(() => {
        getAlladdresss();
    }, [pages])

    useEffect(() => {
        if (dataupdate && !_.isEmpty(dataupdate))
            setopenupdate(true)
    }, [dataupdate])

    useEffect(() => {
        if (openupdate === false)
            setdataupdate({})
    }, [openupdate])

    return (
        <div className='container'>
            <div className='title-address'>
                <Typography sx={{ margin: "10px", fontSize: ismobile ? '13px' : "18px", fontWeight: "550" }}>Danh Sách Address</Typography>
                <Button variant='contained' sx={{
                    marginLeft: "auto",
                    marginRight: "20px",
                    width: ismobile ? '150px' : "200px",
                    height: ismobile ? "35px" : "40px",
                    marginTop: "10px",
                    marginBottom: "10px"
                }}
                    onClick={() => setopencreate(true)}
                >
                    <AddCircleIcon sx={{ fontSize: ismobile ? "15px" : "30px" }} />
                    <Typography sx={{ margin: "10px", fontSize: ismobile ? "10px" : "13x", fontWeight: "550" }}>Thêm mới</Typography>
                </Button>
            </div>
            <div>
                <TableAddress
                    dataaddress={dataaddress}
                    setopenupdate={setopenupdate}
                    setdataupdate={setdataupdate}
                    dataupdate={dataupdate}
                    handleUpdate={handleUpdate}
                />
            </div>
            <div className='address-pagation'>
                <Pagination size={ismobile ? 'small' : ''} count={dataall.totalPages} page={pages} color='primary' onChange={handleChangPage} />

            </div>
            <ModalCreate
                opencreate={opencreate}
                setopencreate={setopencreate}
                createaddress={createaddress}
            />
            <ModalUpdate
                openupdate={openupdate}
                setopenupdate={setopenupdate}
                dataupdate={dataupdate}
                handleUpdateModal={handleUpdateModal}
            />
        </div >
    );
};

export default Address;